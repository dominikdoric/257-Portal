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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UpdateDeleteOglasnik: Fragment(R.layout.update_delete_oglasnik) {

    private lateinit var binding: UpdateDeleteOglasnikBinding
    private val args by navArgs<UpdateDeleteOglasnikArgs>()
    private val collectionRef = Firebase.firestore.collection("oglasnik")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteOglasnikBinding.bind(view)

        binding.naslov.setText(args.updateOglasnikArgs.oglasnikNaslov)
        binding.clanak.setText(args.updateOglasnikArgs.oglasnikClanak)
        binding.cijena.setText(args.updateOglasnikArgs.oglasnikCijena)
        binding.lokacija.setText(args.updateOglasnikArgs.oglasnikLokacija)
        binding.broj.setText(args.updateOglasnikArgs.oglasnikBroj)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            val oglasnik = getOglasnik()
            deleteItem(oglasnik)
            val action = UpdateDeleteOglasnikDirections.actionUpdateDeleteOglasnikToOglasnikNavDrawer()
            findNavController().navigate(action)
        }

    }

    private fun getOglasnik(): OglasnikTable{
        val naslov = binding.naslov.text.toString()
        val clanak = binding.clanak.text.toString()
        val cijena = binding.cijena.text.toString()
        val lokacija = binding.lokacija.text.toString()
        val broj = binding.broj.text.toString()
        return OglasnikTable(clanak,naslov,cijena,lokacija,broj)
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

    private fun azurirajItem() {

    }
}