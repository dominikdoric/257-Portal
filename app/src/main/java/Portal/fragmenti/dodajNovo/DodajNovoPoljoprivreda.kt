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
            val vrijeme = binding.vrijeme.text.toString()
            val poljoprivreda = PoljoprivredaTable(naslov, clanak, vrijeme)
            savePerson(poljoprivreda)
            val action = DodajNovoPoljoprivredaDirections.actionMenuDodajNovuPoljoprivreduToPoljoprivredaNavDrawer()
            findNavController().navigate(action)
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

    /*
    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etPoljoprivredaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etPoljoprivredaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val poljoprivreda = PoljoprivredaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mPoljoprivredaViewModel.addPoljoprivreda(poljoprivreda)
    }

     */

}