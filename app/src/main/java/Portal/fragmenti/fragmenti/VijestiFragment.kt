package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.VijestiFragmentBinding
import Portal.adapter.VijestiAdapter
import Portal.model.VijestiTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class VijestiFragment : Fragment(R.layout.vijesti_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("vijesti")
    var vijestiAdapter: VijestiAdapter? = null
    private lateinit var binding: VijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = VijestiFragmentBinding.bind(view)

        binding.recyclerViewVijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewVijesti.context, DividerItemDecoration.VERTICAL)
        )
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<VijestiTable> =
            FirestoreRecyclerOptions.Builder<VijestiTable>()
                .setQuery(query, VijestiTable::class.java)
                .build()
        vijestiAdapter = VijestiAdapter(tableRecyclerOptions)

        binding.recyclerViewVijesti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewVijesti.adapter = vijestiAdapter
    }

    override fun onStart() {
        super.onStart()
        vijestiAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        vijestiAdapter!!.stopListening()
    }

}
