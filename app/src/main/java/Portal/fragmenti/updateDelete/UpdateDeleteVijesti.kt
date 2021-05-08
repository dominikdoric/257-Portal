package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteVijestiBinding
import Portal.model.VijestiTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.SetOptions
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

        binding.naslovStari.setText(args.updateVijestiArgs.vijestiNaslov)
        binding.clanakStari.setText(args.updateVijestiArgs.vijestiClanak)

        binding.gumbAzuriraj.setOnClickListener {
            val vijesti = getVijesti()
            val vijestiMap = getNewVijestiMap()
            azurirajItem(vijesti,vijestiMap)
            val action = UpdateDeleteVijestiDirections.actionUpdateDeleteVijestiToVijestiNavDrawer()
            findNavController().navigate(action)
        }

        binding.gumbObrisi.setOnClickListener {
            val vijesti = getVijesti()
            obrisiItem(vijesti)
            val action = UpdateDeleteVijestiDirections.actionUpdateDeleteVijestiToVijestiNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getVijesti(): VijestiTable{
        val naslov = binding.naslovStari.text.toString()
        val clanak = binding.clanakStari.text.toString()
        return VijestiTable(naslov,clanak)
    }

    private fun getNewVijestiMap(): Map<String, Any> {
        val naslov = binding.naslovNovi.text.toString()
        val clanak = binding.clanakNovi.text.toString()
        val map = mutableMapOf<String, Any>()
        if (naslov.isNotEmpty()) {
            map["vijestiNaslov"] = naslov
        }
        if (clanak.isNotEmpty()) {
            map["vijestiClanak"] = clanak
        }
        return map
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

    private fun azurirajItem(vijesti: VijestiTable, vijestiMap: Map<String, Any>) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("vijestiClanak", vijesti.vijestiClanak)
            .whereEqualTo("vijestiNaslov", vijesti.vijestiNaslov)
            .get()
            .await()
        if (query.documents.isNotEmpty()) {
            for (document in query) {
                try {
                    collectionRef.document(document.id).set(
                        vijestiMap,
                        SetOptions.merge()
                    ).await()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        } else {
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "Neuspješno", Toast.LENGTH_LONG).show()
            }
        }
    }
}