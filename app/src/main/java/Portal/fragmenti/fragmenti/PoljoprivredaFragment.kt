package Portal.fragmenti.fragmenti

import Portal.MainActivity
import Portal.a257.R
import Portal.a257.databinding.PoljoprivredaFragmentBinding
import Portal.adapter.PoljoprivredaAdapter
import Portal.model.PoljoprivredaTable
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

class PoljoprivredaFragment : Fragment(R.layout.poljoprivreda_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("poljoprivreda")
    private lateinit var auth: FirebaseAuth
    var poljoprivredaAdapter: PoljoprivredaAdapter? = null
    private lateinit var binding: PoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PoljoprivredaFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        binding.recyclerViewPoljoprivreda.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewPoljoprivreda.context, DividerItemDecoration.VERTICAL
            )
        )

        binding.floatingActionButton.setOnClickListener {
            if (auth.currentUser != null) {
                val action =
                    PoljoprivredaFragmentDirections.actionPoljoprivredaNavDrawerToMenuDodajNovuPoljoprivredu()
                findNavController().navigate(action)
            } else {
                Toast.makeText(
                    requireContext(), "Nažalost ne možete dodavati članke u rubrici Poljoprivreda.",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

        setUpRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (activity as MainActivity?)?.showBottomNavigationView()
        }
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