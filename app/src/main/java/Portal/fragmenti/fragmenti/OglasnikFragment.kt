package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.OglasnikFragmentBinding
import Portal.adapter.OglasnikAdapter
import Portal.database.table.OglasnikTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class OglasnikFragment : Fragment(R.layout.oglasnik_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("oglasnik")
    var oglasnikAdapter: OglasnikAdapter? = null
    private lateinit var binding: OglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OglasnikFragmentBinding.bind(view)

        binding.recyclerViewOglasnik.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewOglasnik.context, DividerItemDecoration.VERTICAL)
        )
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<OglasnikTable> =
            FirestoreRecyclerOptions.Builder<OglasnikTable>()
                .setQuery(query, OglasnikTable::class.java)
                .build()
        oglasnikAdapter = OglasnikAdapter(tableRecyclerOptions)

        binding.recyclerViewOglasnik.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewOglasnik.adapter = oglasnikAdapter
    }

    override fun onStart() {
        super.onStart()
        oglasnikAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        oglasnikAdapter!!.stopListening()
    }

}