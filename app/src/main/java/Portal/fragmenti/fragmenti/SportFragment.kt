package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.adapter.SportAdapter
import Portal.firestore.SportFirestore
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
    var personAdapter: SportAdapter? = null
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
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<SportFirestore> =
            FirestoreRecyclerOptions.Builder<SportFirestore>()
                .setQuery(query, SportFirestore::class.java)
                .build()
        personAdapter = SportAdapter(firestoreRecyclerOptions)

        binding.recyclerViewSport.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSport.adapter = personAdapter
    }

    override fun onStart() {
        super.onStart()
        personAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        personAdapter!!.stopListening()
    }

}