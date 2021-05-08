package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteObavijestiBinding
import Portal.model.ObavijestiTable
import Portal.model.SportTable
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

class UpdateDeleteObavijesti: Fragment(R.layout.update_delete_obavijesti) {

    private lateinit var binding: UpdateDeleteObavijestiBinding
    private val args by navArgs<UpdateDeleteObavijestiArgs>()
    private val collectionRef = Firebase.firestore.collection("obavijest")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteObavijestiBinding.bind(view)

        binding.naslovStari.setText(args.updateObavijestiArgs.obavijestiNaslov)
        binding.clanakStari.setText(args.updateObavijestiArgs.obavijestiClanak)

        binding.gumbAzuriraj.setOnClickListener {
            val oldObavijesti = getObavijesti()
            val obavijestiMap = getNewObavijestiMap()
            azurirajItem(oldObavijesti,obavijestiMap)
            val action = UpdateDeleteObavijestiDirections.actionUpdateDeleteObavijestiToObavijestiNavDrawer()
            findNavController().navigate(action)
        }

        binding.gumbObrisi.setOnClickListener {
            val obavijesti = getObavijesti()
            deleteItem(obavijesti)
            val action = UpdateDeleteObavijestiDirections.actionUpdateDeleteObavijestiToObavijestiNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getObavijesti(): ObavijestiTable {
        val naslov = binding.naslovStari.text.toString()
        val clanak = binding.clanakStari.text.toString()
        return ObavijestiTable(naslov,clanak)
    }

    private fun getNewObavijestiMap(): Map<String, Any> {
        val naslov = binding.naslovNovi.text.toString()
        val clanak = binding.clanakNovi.text.toString()
        val map = mutableMapOf<String, Any>()
        if (naslov.isNotEmpty()) {
            map["obavijestiNaslov"] = naslov
        }
        if (clanak.isNotEmpty()) {
            map["obavijestiClanak"] = clanak
        }
        return map
    }

    private fun deleteItem(obavijesti: ObavijestiTable) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("obavijestiNaslov", obavijesti.obavijestiNaslov)
            .whereEqualTo("obavijestiClanak", obavijesti.obavijestiClanak)
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

    private fun azurirajItem(obavijesti: ObavijestiTable, obavijestiMap: Map<String, Any>) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("obavijestiClanak", obavijesti.obavijestiClanak)
            .whereEqualTo("obavijestiNaslov", obavijesti.obavijestiNaslov)
            .get()
            .await()
        if (query.documents.isNotEmpty()) {
            for (document in query) {
                try {
                    collectionRef.document(document.id).set(
                        obavijestiMap,
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