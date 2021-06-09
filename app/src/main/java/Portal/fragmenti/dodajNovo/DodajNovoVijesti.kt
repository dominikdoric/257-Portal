package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoVijestiFragmentBinding
import Portal.model.VijestiTable
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
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
                val action = DodajNovoVijestiDirections.actionMenuDodajNovuVijestToVijestiNavDrawer()
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