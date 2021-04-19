package Portal.firestore

import Portal.a257.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_recycler.*

class FirestoreFragment: Fragment(R.layout.firestore_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("persons")
    var userAdapter: FirestoreAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val firestoreRecyclerOption: FirestoreRecyclerOptions<Person> =
            FirestoreRecyclerOptions.Builder<Person>()
                .setQuery(query,Person::class.java)
                .build()
        userAdapter = FirestoreAdapter(firestoreRecyclerOption)
        firestoreRecycler.layoutManager = LinearLayoutManager(requireContext())
        firestoreRecycler.adapter = userAdapter
    }

    /*
    override fun onStart() {
        super.onStart()
        userAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        userAdapter!!.stopListening()
    }
     */

}