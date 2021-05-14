package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoPoljoprivredaFragmentBinding
import Portal.model.PoljoprivredaTable
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


class DodajNovoPoljoprivreda: Fragment(R.layout.dodaj_novo_poljoprivreda_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("poljoprivreda")
    private lateinit var binding: DodajNovoPoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoPoljoprivredaFragmentBinding.bind(view)

        binding.gumbSpremiPoljoprivredu.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val poljoprivreda = PoljoprivredaTable(naslov, clanak)

            if (binding.naslov.text.isNullOrEmpty()){
                binding.naslov.error = "Naslov ne može biti prazan!"
            }else if (binding.clanak.text.isNullOrEmpty()){
                binding.clanak.error = "Članak ne može biti prazan!"
            }else{
                savePerson(poljoprivreda)
                val action = DodajNovoPoljoprivredaDirections.actionMenuDodajNovuPoljoprivreduToPoljoprivredaNavDrawer()
                findNavController().navigate(action)
            }
        }
    }

    private fun savePerson(poljoprivreda: PoljoprivredaTable) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(poljoprivreda).await()
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