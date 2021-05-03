package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoZabavaFragmentBinding
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.StringBuilder

@AndroidEntryPoint
class DodajNovoZabava : Fragment(R.layout.dodaj_novo_zabava_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("zabava")
    private lateinit var binding: DodajNovoZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoZabavaFragmentBinding.bind(view)

        binding.gumbSpremiZabavu.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vrijeme = binding.vrijeme.text.toString()
            val zabava = ZabavaTable(naslov, clanak, vrijeme)
            savePerson(zabava)
        }

        binding.gumbPrikaziZabavu.setOnClickListener {
            retrievePersons()
        }
    }

    private fun savePerson(zabava: ZabavaTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(zabava).await()
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
                val zabava = document.toObject<ZabavaTable>()
                sb.append("$zabava\n")
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

        val noviNaslov = binding.etZabavaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etZabavaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val zabava = ZabavaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mZabavaViewModel.addZabava(zabava)
    }

     */
}