package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteVijestiBinding
import Portal.model.VijestiTable
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

class UpdateDeleteVijesti: Fragment(R.layout.update_delete_vijesti) {

    private lateinit var binding: UpdateDeleteVijestiBinding
    private val args by navArgs<UpdateDeleteVijestiArgs>()
    private val collectionRef = Firebase.firestore.collection("vijesti")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteVijestiBinding.bind(view)

        binding.naslov.setText(args.updateVijestiArgs.vijestiNaslov)
        binding.clanak.setText(args.updateVijestiArgs.vijestiClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val vijesti = getVijesti()
            obrisiItem(vijesti)
        }

    }

    private fun getVijesti(): VijestiTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        return VijestiTable(naslov,clanak)
    }

    private fun obrisiItem(vijesti: VijestiTable) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("vijestiNaslov", vijesti.vijestiNaslov)
            .whereEqualTo("vijestiClanak", vijesti.vijestiClanak)
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