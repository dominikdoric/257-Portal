package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.model.SportTable
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class DodajNovoSport : Fragment(R.layout.dodaj_novo_sport_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("sport")
    private lateinit var binding: DodajNovoSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoSportFragmentBinding.bind(view)

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

        binding.gumbOdaberiSLikuSport.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }

        binding.gumbUslikajSport.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            val bmp = data?.extras?.get("data") as Bitmap
            binding.imageViewSport.setImageBitmap(bmp)
        } else if (requestCode == 456) {
            binding.imageViewSport.setImageURI(data?.data)
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

}