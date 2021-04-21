package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.adapter.SportAdapter
import Portal.firestore.FirestoreSportAdapter
import Portal.firestore.SportModel
import Portal.viewModel.SportViewModel
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
import kotlinx.android.synthetic.main.firestore_sport_fragment.*

@AndroidEntryPoint
class SportFragment : Fragment(R.layout.firestore_sport_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("sport")
    var sportAdapter: SportAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sportFirestoreRecycler.addItemDecoration(
            DividerItemDecoration(
                sportFirestoreRecycler.context,DividerItemDecoration.VERTICAL
            )
        )
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val firestoreRecyclerOption: FirestoreRecyclerOptions<SportModel> =
            FirestoreRecyclerOptions.Builder<SportModel>()
                .setQuery(query, SportModel::class.java)
                .build()
        sportAdapter = SportAdapter(firestoreRecyclerOption)
        sportFirestoreRecycler.layoutManager = LinearLayoutManager(requireContext())
        sportFirestoreRecycler.adapter = sportAdapter
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