package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.database.table.SportTable
import Portal.firestore.SportModel
import Portal.viewModel.SportViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoSport : Fragment(R.layout.dodaj_novo_sport_fragment) {

    private val mSportViewModel: SportViewModel by viewModels()
    private lateinit var binding: DodajNovoSportFragmentBinding

    private val personCollectionRef = Firebase.firestore.collection("sport")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoSportFragmentBinding.bind(view)

        gumbSpremiSport.setOnClickListener {
            val sport = getSport()
            saveSport(sport)
        }

        /*
        binding.gumbSpremiSport.setOnClickListener {
            if (binding.etSportNaslov.text.toString().trim().isEmpty()){
                binding.etSportNaslov.error = "Ovo polje je obavezno!"
            }else if (binding.etSportClanak.text.toString().trim().isEmpty()){
                binding.etSportClanak.error = "Ovo polje je obavezno"
            }
            else{
                insertDataToDatabase()
                //val action = DodajNovoSportDirections.actionMenuDodajNoviSportToSportNavDrawer()
                //findNavController().navigate(action)
                Toast.makeText(
                    requireContext(),
                    "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
         */

    }

    private fun saveSport(sport: SportModel) = CoroutineScope(Dispatchers.IO).launch{
        try {
            personCollectionRef.add(sport)
            withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),"Uspješno dodani podaci u bazu",Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),e.message,Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getSport(): SportModel{
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslov = et_sport_naslov.text.toString()
        val clanak = et_sport_clanak.text.toString()
        val vrijeme = currentDate
        val slika = 1

        return SportModel(naslov,clanak,vrijeme,slika)
    }

    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etSportNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etSportClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val sport = SportTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mSportViewModel.addSport(sport)
    }

}