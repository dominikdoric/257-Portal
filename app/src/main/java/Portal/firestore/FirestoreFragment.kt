package Portal.firestore

import Portal.a257.R
import Portal.a257.databinding.FirestoreFragmentBinding
import Portal.database.table.SportTable
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

class FirestoreFragment : Fragment(R.layout.firestore_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("sport")
    private lateinit var binding: FirestoreFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirestoreFragmentBinding.bind(view)

        binding.firstoreSpremi.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val vrijeme = binding.vrijeme.text.toString()
            val sport = SportTable(naslov, clanak, vrijeme)
            savePerson(sport)
        }

        binding.firstorePrikazi.setOnClickListener {
            retrievePersons()
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

    private fun retrievePersons() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = personCollectionRef.get().await()
            val sb = StringBuilder()
            for (document in querySnapshot.documents) {
                val sport = document.toObject<SportTable>()
                sb.append("$sport\n")
            }
            withContext(Dispatchers.Main) {
                binding.textViewFirestore.text = sb.toString()
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

}