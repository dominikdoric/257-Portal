package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ZabavaFragmentBinding
import Portal.adapter.ZabavaAdapter
import Portal.database.table.ZabavaTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ZabavaFragment : Fragment(R.layout.zabava_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("zabava")
    var zabavaAdapter: ZabavaAdapter? = null
    private lateinit var binding: ZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZabavaFragmentBinding.bind(view)

        binding.recyclerViewZabava.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewZabava.context, DividerItemDecoration.VERTICAL)
        )

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<ZabavaTable> =
            FirestoreRecyclerOptions.Builder<ZabavaTable>()
                .setQuery(query, ZabavaTable::class.java)
                .build()
        zabavaAdapter = ZabavaAdapter(tableRecyclerOptions)

        binding.recyclerViewZabava.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewZabava.adapter = zabavaAdapter
    }

    override fun onStart() {
        super.onStart()
        zabavaAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        zabavaAdapter!!.stopListening()
    }

}
