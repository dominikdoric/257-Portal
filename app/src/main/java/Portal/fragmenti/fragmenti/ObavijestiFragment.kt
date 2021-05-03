package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ObavijestiFragmentBinding
import Portal.adapter.ObavijestiAdapter
import Portal.adapter.SportAdapter
import Portal.database.table.ObavijestiTable
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
class ObavijestiFragment : Fragment(R.layout.obavijesti_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("obavijest")
    var obavijestiAdapter: ObavijestiAdapter? = null
    private lateinit var binding: ObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ObavijestiFragmentBinding.bind(view)


        binding.recyclerViewObavijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewObavijesti.context, DividerItemDecoration.VERTICAL)
        )

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<ObavijestiTable> =
            FirestoreRecyclerOptions.Builder<ObavijestiTable>()
                .setQuery(query, ObavijestiTable::class.java)
                .build()
        obavijestiAdapter = ObavijestiAdapter(tableRecyclerOptions)

        binding.recyclerViewObavijesti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewObavijesti.adapter = obavijestiAdapter
    }

    override fun onStart() {
        super.onStart()
        obavijestiAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        obavijestiAdapter!!.stopListening()
    }

}
