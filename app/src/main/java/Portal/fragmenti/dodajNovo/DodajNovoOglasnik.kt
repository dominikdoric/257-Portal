package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoOglasnikFragmentBinding
import Portal.model.OglasnikTable
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


class DodajNovoOglasnik : Fragment(R.layout.dodaj_novo_oglasnik_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("oglasnik")
    private lateinit var binding: DodajNovoOglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoOglasnikFragmentBinding.bind(view)

        binding.gumbSpremiOglasnik.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vrijeme = binding.vrijeme.text.toString()
            val cijena = binding.cijena.text.toString()
            val lokacija = binding.lokacija.text.toString()
            val broj = binding.broj.text.toString()
            val oglasnik = OglasnikTable(clanak, naslov, cijena, lokacija, broj, vrijeme)
            savePerson(oglasnik)
        }

        binding.gumbPrikaziOglasnik.setOnClickListener {
            retrievePersons()
        }

    }

    private fun savePerson(oglasnik: OglasnikTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(oglasnik).await()
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
                val oglasnik = document.toObject<OglasnikTable>()
                sb.append("$oglasnik\n")
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

}