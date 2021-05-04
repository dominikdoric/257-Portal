package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoObavijestiFragmentBinding
import Portal.model.ObavijestiTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

class DodajNovoObavijesti : Fragment(R.layout.dodaj_novo_obavijesti_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("obavijest")
    private lateinit var binding: DodajNovoObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoObavijestiFragmentBinding.bind(view)

        binding.gumbSpremiObavijest.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val obavijest = ObavijestiTable(naslov, clanak)
            savePerson(obavijest)
            val action = DodajNovoObavijestiDirections.actionMenuDodajNovuObavijestToObavijestiNavDrawer()
            findNavController().navigate(action)
        }
    }

    private fun savePerson(obavijest: ObavijestiTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(obavijest).await()
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