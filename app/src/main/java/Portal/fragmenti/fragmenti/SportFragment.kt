package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.adapter.SportAdapter
import Portal.database.table.SportTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportFragment : Fragment(R.layout.sport_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("sport")
    var sportAdapter: SportAdapter? = null
    private lateinit var binding: SportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SportFragmentBinding.bind(view)

        binding.recyclerViewSport.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewSport.context,DividerItemDecoration.VERTICAL)
        )

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<SportTable> =
            FirestoreRecyclerOptions.Builder<SportTable>()
                .setQuery(query, SportTable::class.java)
                .build()
        sportAdapter = SportAdapter(tableRecyclerOptions)

        binding.recyclerViewSport.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSport.adapter = sportAdapter
    }

    override fun onStart() {
        super.onStart()
        sportAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        sportAdapter!!.stopListening()
    }

}