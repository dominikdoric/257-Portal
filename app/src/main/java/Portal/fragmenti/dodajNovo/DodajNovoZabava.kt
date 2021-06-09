package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoZabavaFragmentBinding
import Portal.model.ZabavaTable
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.StringBuilder

class DodajNovoZabava : Fragment(R.layout.dodaj_novo_zabava_fragment), View.OnClickListener {

    private val personCollectionRef = Firebase.firestore.collection("zabava")
    private lateinit var binding: DodajNovoZabavaFragmentBinding

    companion object {
        private const val CAMERA = 1
        private const val GALLERY = 2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoZabavaFragmentBinding.bind(view)

        binding.gumbSpremiZabava.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val zabava = ZabavaTable(naslov, clanak)

            if(binding.naslov.text.isNullOrEmpty()){
                binding.naslov.error = "Naslov ne može biti prazan!"
            }else if (binding.clanak.text.isNullOrEmpty()){
                binding.clanak.error = "Članak ne može biti prazan!"
            }else{
                savePerson(zabava)
                val action = DodajNovoZabavaDirections.actionMenuDodajNovuZabavaToZabavaNavDrawer()
                findNavController().navigate(action)
            }
        }
    }

    private fun savePerson(zabava: ZabavaTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(zabava).await()
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
                R.id.addImageZabava -> {
                    customImageSelectionDialog()
                    return
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA) {
                data?.let {
                    val thumbnail: Bitmap = data.extras?.get("data") as Bitmap
                    binding.imageViewZabava.setImageBitmap(thumbnail)

                    binding.addImageZabava.setImageDrawable(
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
                binding.imageViewZabava.setImageURI(selectedPhotoUri)

                binding.addImageZabava.setImageDrawable(
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