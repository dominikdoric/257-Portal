package Portal.firestore

import Portal.a257.R
import Portal.a257.databinding.FirestoreRecyclerBinding
import Portal.adapter.SportAdapter
import Portal.database.table.SportTable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class FirestoreRecycler : Fragment(R.layout.firestore_recycler) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("sport")
    var personAdapter: SportAdapter? = null
    private lateinit var binding: FirestoreRecyclerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirestoreRecyclerBinding.bind(view)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<SportTable> =
            FirestoreRecyclerOptions.Builder<SportTable>()
                .setQuery(query, SportTable::class.java)
                .build()
        personAdapter = SportAdapter(tableRecyclerOptions)

        binding.firestoreRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.firestoreRecycler.adapter = personAdapter
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