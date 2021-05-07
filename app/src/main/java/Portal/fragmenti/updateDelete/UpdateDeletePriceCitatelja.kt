package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePriceCitateljaBinding
import Portal.model.PriceCitateljaTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UpdateDeletePriceCitatelja: Fragment(R.layout.update_delete_price_citatelja) {

    private lateinit var binding: UpdateDeletePriceCitateljaBinding
    private val args by navArgs<UpdateDeletePriceCitateljaArgs>()
    private val collectionRef = Firebase.firestore.collection("priceCitatelja")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePriceCitateljaBinding.bind(view)

        binding.naslov.setText(args.updateCitateljeArgs.priceCitateljaNaslov)
        binding.clanak.setText(args.updateCitateljeArgs.priceCitateljaClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val priceCitatelja = getPriceCitatelja()
            deleteItem(priceCitatelja)
        }

    }

    private fun getPriceCitatelja(): PriceCitateljaTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        return PriceCitateljaTable(naslov,clanak)
    }

    private fun deleteItem(priceCitatelja: PriceCitateljaTable) = CoroutineScope(Dispatchers.IO).launch{
        val query = collectionRef
            .whereEqualTo("priceCitateljaNaslov", priceCitatelja.priceCitateljaNaslov)
            .whereEqualTo("priceCitateljaClanak", priceCitatelja.priceCitateljaClanak)
            .get()
            .await()
        if (query.documents.isNotEmpty()) {
            for (document in query) {
                try {
                    collectionRef.document(document.id).delete().await()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            "No persons matched the query.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        } else {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "No persons matched the query.", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun azurirajItem() {

    }
}