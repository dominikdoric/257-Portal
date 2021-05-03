package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoPriceCitateljaFragmentBinding
import Portal.model.PriceCitateljaTable
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

class DodajNovoPriceCitatelja : Fragment(R.layout.dodaj_novo_price_citatelja_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("priceCitatelja")
    private lateinit var binding: DodajNovoPriceCitateljaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoPriceCitateljaFragmentBinding.bind(view)

        binding.gumbSpremiPriceCitatelja.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vrijeme = binding.vrijeme.text.toString()
            val priceCitatelja = PriceCitateljaTable(naslov, clanak, vrijeme)
            savePerson(priceCitatelja)
        }

        binding.gumbPrikaziPriceCitatelja.setOnClickListener {
            retrievePersons()
        }
    }

    private fun savePerson(priceCitatelja: PriceCitateljaTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(priceCitatelja).await()
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "Uspješno spremljeno!", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun retrievePersons() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = personCollectionRef.get().await()
            val sb = StringBuilder()
            for (document in querySnapshot.documents) {
                val priceCitatelja = document.toObject<PriceCitateljaTable>()
                sb.append("$priceCitatelja\n")
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    /*
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etPriceCitateljaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etPriceCitateljaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val priceCitatelja = PriceCitateljaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mPriceCitateljaViewModel.addPriceCitatelja(priceCitatelja)
    }
     */

}