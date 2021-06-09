package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DialogCustomImageSelectionBinding
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.model.SportTable
import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class DodajNovoSport : Fragment(R.layout.dodaj_novo_sport_fragment), View.OnClickListener {

    private val personCollectionRef = Firebase.firestore.collection("sport")
    private lateinit var binding: DodajNovoSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoSportFragmentBinding.bind(view)

        binding.addImageSport.setOnClickListener(this)

        binding.gumbSpremiSport.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val sport = SportTable(naslov, clanak)

            if (binding.naslov.text.isNullOrEmpty()) {
                binding.naslov.error = "Naslov ne može biti prazan!"
            } else if (binding.clanak.text.isNullOrEmpty()) {
                binding.clanak.error = "Članak ne može biti prazan!"
            } else {
                savePerson(sport)
                val action = DodajNovoSportDirections.actionMenuDodajNoviSportToSportNavDrawer()
                findNavController().navigate(action)
            }
        }
    }

    private fun savePerson(sport: SportTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(sport).await()
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
                R.id.addImageSport -> {
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
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report!!.areAllPermissionsGranted()) {
                        Toast.makeText(
                            requireContext(), "You have camera permission now",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    //Show Alert Dialog
                }})
                .onSameThread()
                .check()

            dialog.dismiss()
        }
        binding.tvGallery.setOnClickListener {
            Toast.makeText(requireContext(), "Gallery clicked", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.setContentView(binding.root)
        dialog.show()
    }

    private fun showRationaleDialogForPermissions(){
        AlertDialog.Builder(requireContext())
            .setMessage("Izgleda da ste isključili dozvolu potrebnu za ovaj dio. Ona ponovno" +
                    " može biti omogućena u postavkama aplikacije")
            .setPositiveButton("Go to settings"){_,_ ->
                try {

                }
            }
    }
}