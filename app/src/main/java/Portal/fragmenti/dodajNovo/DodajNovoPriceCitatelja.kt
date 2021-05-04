package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoPriceCitateljaFragmentBinding
import Portal.model.PriceCitateljaTable
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

class DodajNovoPriceCitatelja : Fragment(R.layout.dodaj_novo_price_citatelja_fragment) {

    private val personCollectionRef = Firebase.firestore.collection("priceCitatelja")
    private lateinit var binding: DodajNovoPriceCitateljaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoPriceCitateljaFragmentBinding.bind(view)

        binding.gumbSpremiPriceCitatelja.setOnClickListener {
            val naslov = binding.naslov.text.toString()
            val clanak = binding.clanak.text.toString()
            val priceCitatelja = PriceCitateljaTable(naslov, clanak)
            savePerson(priceCitatelja)
            val action = DodajNovoPriceCitateljaDirections.actionMenuDodajNovuPricuCitateljaToPriceCitateljaNavDrawer()
            findNavController().navigate(action)
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
}