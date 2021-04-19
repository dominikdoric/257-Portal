package Portal.firestore

import Portal.a257.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("persons")
    var userAdapter: FirestoreAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val firestoreRecyclerOption: FirestoreRecyclerOptions<Person> =
            FirestoreRecyclerOptions.Builder<Person>()
                .setQuery(query,Person::class.java)
                .build()
        userAdapter = FirestoreAdapter(firestoreRecyclerOption)
        firestoreRecycler.layoutManager = LinearLayoutManager(this)
        firestoreRecycler.adapter = userAdapter
    }

    override fun onStart() {
        super.onStart()
        userAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        userAdapter!!.stopListening()
    }

}