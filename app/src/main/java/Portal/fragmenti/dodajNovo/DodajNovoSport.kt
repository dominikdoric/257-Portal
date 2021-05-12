package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.model.SportTable
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_DENIED){
                //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                }else{
                        //permission already granted
                    odaberiSliku()
                }
            }
            else{
                //system OS is < Marshmallow
                odaberiSliku()
            }
        }
    }

    private fun odaberiSliku() {

    }

    companion object{
        private val IMAGE_PICK_CODE = 100
        private val PERMISSION_CODE = 1001
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