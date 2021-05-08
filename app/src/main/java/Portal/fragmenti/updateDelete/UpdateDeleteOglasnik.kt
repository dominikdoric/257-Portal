package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteOglasnikBinding
import Portal.model.OglasnikTable
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

class UpdateDeleteOglasnik : Fragment(R.layout.update_delete_oglasnik) {

    private lateinit var binding: UpdateDeleteOglasnikBinding
    private val args by navArgs<UpdateDeleteOglasnikArgs>()
    private val collectionRef = Firebase.firestore.collection("oglasnik")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteOglasnikBinding.bind(view)

        binding.naslovStari.setText(args.updateOglasnikArgs.oglasnikNaslov)
        binding.clanakStari.setText(args.updateOglasnikArgs.oglasnikClanak)
        binding.cijenaStari.setText(args.updateOglasnikArgs.oglasnikCijena)
        binding.lokacijaStari.setText(args.updateOglasnikArgs.oglasnikLokacija)
        binding.brojStari.setText(args.updateOglasnikArgs.oglasnikBroj)

        binding.gumbAzuriraj.setOnClickListener {
            val oglasnik = getOglasnik()
            val oglasnikMap = getNewOglasnikMap()
            azurirajItem(oglasnik,oglasnikMap)
            val action = UpdateDeleteOglasnikDirections.actionUpdateDeleteOglasnikToOglasnikNavDrawer()
            findNavController().navigate(action)
        }

        binding.gumbObrisi.setOnClickListener {
            val oglasnik = getOglasnik()
            deleteItem(oglasnik)
            val action =
                UpdateDeleteOglasnikDirections.actionUpdateDeleteOglasnikToOglasnikNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getOglasnik(): OglasnikTable {
        val naslov = binding.naslovStari.text.toString()
        val clanak = binding.clanakStari.text.toString()
        val cijena = binding.cijenaStari.text.toString()
        val lokacija = binding.lokacijaStari.text.toString()
        val broj = binding.brojStari.text.toString()
        return OglasnikTable(clanak, naslov, cijena, lokacija, broj)
    }

    private fun getNewOglasnikMap(): Map<String, Any> {
        val naslov = binding.naslovNovi.text.toString()
        val clanak = binding.clanakNovi.text.toString()
        val cijena = binding.cijenaNovi.text.toString()
        val lokacija = binding.lokacijaNovi.text.toString()
        val broj = binding.brojNovi.text.toString()
        val map = mutableMapOf<String, Any>()
        if (naslov.isNotEmpty()) {
            map["oglasnikNaslov"] = naslov
        }
        if (clanak.isNotEmpty()) {
            map["oglasnikClanak"] = clanak
        }
        if (cijena.isNotEmpty()) {
            map["oglasnikCijena"] = cijena
        }
        if (clanak.isNotEmpty()) {
            map["oglasnikLokacija"] = lokacija
        }
        if (clanak.isNotEmpty()) {
            map["oglasnikBroj"] = broj
        }
        return map
    }

    private fun deleteItem(oglasnik: OglasnikTable) = CoroutineScope(Dispatchers.IO).launch {
        val query = collectionRef
            .whereEqualTo("oglasnikNaslov", oglasnik.oglasnikNaslov)
            .whereEqualTo("oglasnikClanak", oglasnik.oglasnikClanak)
            .whereEqualTo("oglasnikCijena", oglasnik.oglasnikCijena)
            .whereEqualTo("oglasnikLokacija", oglasnik.oglasnikLokacija)
            .whereEqualTo("oglasnikBroj", oglasnik.oglasnikBroj)
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

    private fun azurirajItem(oglasnik: OglasnikTable, oglasnikMap: Map<String, Any>) =
        CoroutineScope(Dispatchers.IO).launch {
            val query = collectionRef
                .whereEqualTo("oglasnikClanak", oglasnik.oglasnikClanak)
                .whereEqualTo("oglasnikNaslov", oglasnik.oglasnikNaslov)
                .whereEqualTo("oglasnikCijena", oglasnik.oglasnikCijena)
                .whereEqualTo("oglasnikLokacija", oglasnik.oglasnikLokacija)
                .whereEqualTo("oglasnikBroj", oglasnik.oglasnikBroj)
                .get()
                .await()
            if (query.documents.isNotEmpty()) {
                for (document in query) {
                    try {
                        collectionRef.document(document.id).set(
                            oglasnikMap,
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