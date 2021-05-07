package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteZabavaBinding
import Portal.model.ZabavaTable
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

class UpdateDeleteZabava: Fragment(R.layout.update_delete_zabava) {

    private lateinit var binding: UpdateDeleteZabavaBinding
    private val args by navArgs<UpdateDeleteZabavaArgs>()
    private val collectionRef = Firebase.firestore.collection("zabava")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteZabavaBinding.bind(view)

        binding.naslov.setText(args.updateZabavaArgs.zabavaNaslov)
        binding.clanak.setText(args.updateZabavaArgs.zabavaClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val zabava = getZabava()
            deleteItem(zabava)
            val action = UpdateDeleteZabavaDirections.actionUpdateDeleteZabavaToZabavaNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getZabava(): ZabavaTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        return ZabavaTable(naslov,clanak)
    }

    private fun deleteItem(zabava: ZabavaTable) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("zabavaNaslov", zabava.zabavaNaslov)
            .whereEqualTo("vijestiClanak", zabava.zabavaClanak)
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