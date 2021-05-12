package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.model.SportTable
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
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
            savePerson(sport)
            val action = DodajNovoSportDirections.actionMenuDodajNoviSportToSportNavDrawer()
            findNavController().navigate(action)
        }

        binding.gumbOdaberiSLikuSport.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED
            ) {
                //permission denied
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_CODE)
            } else {
                //permission already granted
                odaberiSliku()
            }
        }
    }

    private fun odaberiSliku() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 100
        private val PERMISSION_CODE = 1001
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    odaberiSliku()
                }
                else{
                    Toast.makeText(requireContext(),"Permission denied",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
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