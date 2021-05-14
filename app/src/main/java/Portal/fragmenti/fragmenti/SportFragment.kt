package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.adapter.SportAdapter
import Portal.model.SportTable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class SportFragment : Fragment(R.layout.sport_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("sport")
    private lateinit var auth: FirebaseAuth
    var sportAdapter: SportAdapter? = null
    private lateinit var binding: SportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SportFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        binding.recyclerViewSport.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewSport.context, DividerItemDecoration.VERTICAL)
        )

        binding.floatingActionButton.setOnClickListener {
            if (auth.currentUser != null) {
                val action = SportFragmentDirections.actionSportNavDrawerToMenuDodajNoviSport()
                findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext(), "Nažalost ne možete dodavati članke u rubrici Sport.",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }

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