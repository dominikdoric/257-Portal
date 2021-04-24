package Portal.fragmenti.dodajNovo

import Portal.a257.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
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

    private val personCollectionRef = Firebase.firestore.collection("sport")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gumbSpremiSport.setOnClickListener {
            val sport = getSport()
            saveSport(sport)
        }
    }

    private fun saveSport(sport: SportModel) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(sport)
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "Uspješno dodani podaci u bazu", Toast.LENGTH_LONG)
                    .show()
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getSport(): SportModel {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslov = et_sport_naslov.text.toString()
        val clanak = et_sport_clanak.text.toString()
        val vrijeme = currentDate
        val slika = 1

        return SportModel(naslov, clanak, vrijeme, slika)
    }
}