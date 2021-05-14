package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ZabavaFragmentBinding
import Portal.adapter.ZabavaAdapter
import Portal.model.ZabavaTable
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

class ZabavaFragment : Fragment(R.layout.zabava_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("zabava")
    private lateinit var auth: FirebaseAuth
    var zabavaAdapter: ZabavaAdapter? = null
    private lateinit var binding: ZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZabavaFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        binding.recyclerViewZabava.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewZabava.context, DividerItemDecoration.VERTICAL)
        )

        binding.floatingActionButton.setOnClickListener {
            if (auth.currentUser != null){
                val action = ZabavaFragmentDirections.actionZabavaNavDrawerToMenuDodajNovuZabava()
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(),"Nažalost ne možete dodavati članke u rubrici Zabava.",
                Toast.LENGTH_LONG)
                    .show()
            }
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<ZabavaTable> =
            FirestoreRecyclerOptions.Builder<ZabavaTable>()
                .setQuery(query, ZabavaTable::class.java)
                .build()
        zabavaAdapter = ZabavaAdapter(tableRecyclerOptions)

        binding.recyclerViewZabava.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewZabava.adapter = zabavaAdapter
    }

    override fun onStart() {
        super.onStart()
        zabavaAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        zabavaAdapter!!.stopListening()
    }

}
