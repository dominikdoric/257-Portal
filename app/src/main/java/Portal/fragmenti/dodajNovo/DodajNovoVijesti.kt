package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoVijestiFragmentBinding
import Portal.model.VijestiTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
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

class DodajNovoVijesti : Fragment(R.layout.dodaj_novo_vijesti_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("vijesti")
    private lateinit var binding: DodajNovoVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoVijestiFragmentBinding.bind(view)

        binding.gumbSpremiVijest.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vrijeme = binding.vrijeme.text.toString()
            val vijesti = VijestiTable(naslov, clanak, vrijeme)
            savePerson(vijesti)
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
    /*
    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etVijestiNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etVijestiClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val vijesti = VijestiTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mVijestiViewModel.addVijesti(vijesti)
    }
     */
}