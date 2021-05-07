package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteSportBinding
import Portal.model.SportTable
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

class UpdateDeleteSport: Fragment(R.layout.update_delete_sport) {

    private lateinit var binding: UpdateDeleteSportBinding
    private val args by navArgs<UpdateDeleteSportArgs>()
    private val collectionRef = Firebase.firestore.collection("sport")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteSportBinding.bind(view)

        binding.naslov.setText(args.updateSportArgs.naslov)
        binding.clanak.setText(args.updateSportArgs.clanak)

        binding.gumbAzuriraj.setOnClickListener {
            updateItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val sport = getSport()
            deleteItem(sport)
            val action = UpdateDeleteSportDirections.actionUpdateDeleteSportToSportNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getSport(): SportTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        return SportTable(naslov,clanak)
    }

    private fun deleteItem(sport: SportTable) = CoroutineScope(Dispatchers.IO).launch {

        val query = collectionRef
            .whereEqualTo("naslov", sport.naslov)
            .whereEqualTo("clanak", sport.clanak)
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

    private fun updateItem() {

    }

}