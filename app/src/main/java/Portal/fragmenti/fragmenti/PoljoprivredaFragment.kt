package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PoljoprivredaFragmentBinding
import Portal.adapter.PoljoprivredaAdapter
import Portal.adapter.SportAdapter
import Portal.database.table.PoljoprivredaTable
import Portal.database.table.SportTable
import Portal.viewModel.PoljoprivredaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PoljoprivredaFragment : Fragment(R.layout.poljoprivreda_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("poljoprivreda")
    var poljoprivredaAdapter: PoljoprivredaAdapter? = null
    private lateinit var binding: PoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PoljoprivredaFragmentBinding.bind(view)

        binding.recyclerViewPoljoprivreda.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewPoljoprivreda.context, DividerItemDecoration.VERTICAL
            )
        )
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<PoljoprivredaTable> =
            FirestoreRecyclerOptions.Builder<PoljoprivredaTable>()
                .setQuery(query, PoljoprivredaTable::class.java)
                .build()
        poljoprivredaAdapter = PoljoprivredaAdapter(tableRecyclerOptions)

        binding.recyclerViewPoljoprivreda.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPoljoprivreda.adapter = poljoprivredaAdapter
    }

    override fun onStart() {
        super.onStart()
        poljoprivredaAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        poljoprivredaAdapter!!.stopListening()
    }


}