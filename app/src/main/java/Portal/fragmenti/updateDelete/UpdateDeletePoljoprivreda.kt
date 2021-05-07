package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePoljoprivredaBinding
import Portal.model.PoljoprivredaTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UpdateDeletePoljoprivreda: Fragment(R.layout.update_delete_poljoprivreda) {

    private lateinit var binding: UpdateDeletePoljoprivredaBinding
    private val args by navArgs<UpdateDeletePoljoprivredaArgs>()
    private val collectionRef = Firebase.firestore.collection("poljoprivreda")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePoljoprivredaBinding.bind(view)

        binding.naslov.setText(args.poljoprivredaUpdateArgs.poljoprivredaNaslov)
        binding.clanak.setText(args.poljoprivredaUpdateArgs.poljoprivredaClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val poljoprivreda = getPoljoprivreda()
            deleteItem(poljoprivreda)
            val action = UpdateDeletePoljoprivredaDirections.actionUpdateDeletePoljoprivredaToPoljoprivredaNavDrawer()
            findNavController().navigate(action)
        }
    }

    private fun getPoljoprivreda(): PoljoprivredaTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        return PoljoprivredaTable(naslov,clanak)
    }

    private fun deleteItem(poljoprivreda: PoljoprivredaTable) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("poljoprivredaNaslov", poljoprivreda.poljoprivredaNaslov)
            .whereEqualTo("poljoprivredaClanak", poljoprivreda.poljoprivredaClanak)
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