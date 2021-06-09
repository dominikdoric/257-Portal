package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DialogCustomImageSelectionBinding
import Portal.a257.databinding.DodajNovoVijestiFragmentBinding
import Portal.model.VijestiTable
import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.StringBuilder

class DodajNovoVijesti : Fragment(R.layout.dodaj_novo_vijesti_fragment), View.OnClickListener {

    private val personCollectionRef = Firebase.firestore.collection("vijesti")
    private lateinit var binding: DodajNovoVijestiFragmentBinding

    companion object {
        private const val CAMERA = 1
        private const val GALLERY = 2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoVijestiFragmentBinding.bind(view)

        binding.gumbSpremiVijesti.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vijesti = VijestiTable(naslov, clanak)

            if (binding.naslov.text.isNullOrEmpty()) {
                binding.naslov.error = "Naslov ne može biti prazan!"
            } else if (binding.clanak.text.isNullOrEmpty()) {
                binding.clanak.error = "Članak ne može biti prazan!"
            } else {
                savePerson(vijesti)
                val action =
                    DodajNovoVijestiDirections.actionMenuDodajNovuVijestToVijestiNavDrawer()
                findNavController().navigate(action)
            }
        }

    }

    private fun savePerson(vijest: VijestiTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(vijest).await()
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "Uspješno spremljeno!", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.addImageVijesti -> {
                    customImageSelectionDialog()
                    return
                }
            }
        }
    }

    private fun customImageSelectionDialog() {
        val dialog = Dialog(requireContext())
        val binding: DialogCustomImageSelectionBinding =
            DialogCustomImageSelectionBinding.inflate(layoutInflater)

        binding.tvCamera.setOnClickListener {

            Dexter.withContext(requireContext()).withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                //Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    report?.let {
                        if (report.areAllPermissionsGranted()) {
                            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            startActivityForResult(intent, CAMERA)
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    showRationaleDialogForPermissions()
                }
            })
                .onSameThread()
                .check()

            dialog.dismiss()
        }

        binding.tvGallery.setOnClickListener {
            Dexter.withContext(requireContext()).withPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE
            ).withListener(object : PermissionListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    val galleryIntent = Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                    startActivityForResult(galleryIntent, GALLERY)
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    Toast.makeText(
                        requireContext(), "You have denied storage permission",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {
                    showRationaleDialogForPermissions()
                }
            })
                .onSameThread()
                .check()

            dialog.dismiss()
            dialog.dismiss()
        }

        dialog.setContentView(binding.root)
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA) {
                data?.let {
                    val thumbnail: Bitmap = data.extras?.get("data") as Bitmap
                    binding.imageViewVijesti.setImageBitmap(thumbnail)

                    binding.addImageVijesti.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_edit
                        )
                    )
                }
            }
        }
        if (requestCode == GALLERY) {
            data?.let {
                val selectedPhotoUri = data.data
                binding.imageViewVijesti.setImageURI(selectedPhotoUri)

                binding.addImageVijesti.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_edit
                    )
                )
            }
        }
    }

    private fun showRationaleDialogForPermissions() {
        AlertDialog.Builder(requireContext())
            .setMessage(
                "Izgleda da ste isključili dozvolu potrebnu za ovaj dio. Ona ponovno" +
                        " može biti omogućena u postavkama aplikacije"
            )
            .setPositiveButton("Go to settings") { _, _ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", "packageName", null)
                    intent.data = uri
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    e.printStackTrace()
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

}