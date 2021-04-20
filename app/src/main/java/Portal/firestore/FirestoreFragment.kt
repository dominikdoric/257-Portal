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
import kotlinx.android.synthetic.main.firestore_fragment.*

class FirestoreFragment: Fragment(R.layout.firestore_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("sport")
    var sportAdapter: FirestoreAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val firestoreRecyclerOption: FirestoreRecyclerOptions<SportModel> =
            FirestoreRecyclerOptions.Builder<SportModel>()
                .setQuery(query,SportModel::class.java)
                .build()
        sportAdapter = FirestoreAdapter(firestoreRecyclerOption)
        fragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        fragmentRecyclerView.adapter = sportAdapter
    }

    override fun onStart() {
        super.onStart()
        sportAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        sportAdapter!!.stopListening()
    }

}