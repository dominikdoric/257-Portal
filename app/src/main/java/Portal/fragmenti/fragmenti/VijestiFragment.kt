package Portal.fragmenti.fragmenti

import Portal.MainActivity
import Portal.a257.R
import Portal.a257.databinding.VijestiFragmentBinding
import Portal.adapter.VijestiAdapter
import Portal.model.VijestiTable
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
import com.google.firebase.ktx.Firebase

class VijestiFragment : Fragment(R.layout.vijesti_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("vijesti")
    private lateinit var auth: FirebaseAuth
    var vijestiAdapter: VijestiAdapter? = null
    private lateinit var binding: VijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = VijestiFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        binding.recyclerViewVijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewVijesti.context, DividerItemDecoration.VERTICAL)
        )

        binding.floatingActionButton.setOnClickListener {
            if(auth.currentUser != null){
                val action = VijestiFragmentDirections.actionVijestiNavDrawerToMenuDodajNovuVijest()
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(),"Nažalost ne možete dodavati članke u rubrici Vijesti.",
                Toast.LENGTH_LONG)
                    .show()
            }
        }

        setUpRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity){
            (activity as MainActivity?)?.showBottomNavigationView()
        }
    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<VijestiTable> =
            FirestoreRecyclerOptions.Builder<VijestiTable>()
                .setQuery(query, VijestiTable::class.java)
                .build()
        vijestiAdapter = VijestiAdapter(tableRecyclerOptions)

        binding.recyclerViewVijesti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewVijesti.adapter = vijestiAdapter
    }

    override fun onStart() {
        super.onStart()
        vijestiAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        vijestiAdapter!!.stopListening()
    }

}
