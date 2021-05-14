package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ObavijestiFragmentBinding
import Portal.adapter.ObavijestiAdapter
import Portal.model.ObavijestiTable
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

class ObavijestiFragment : Fragment(R.layout.obavijesti_fragment) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("obavijest")
    private lateinit var auth: FirebaseAuth
    var obavijestiAdapter: ObavijestiAdapter? = null
    private lateinit var binding: ObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ObavijestiFragmentBinding.bind(view)
        auth = FirebaseAuth.getInstance()


        binding.recyclerViewObavijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewObavijesti.context, DividerItemDecoration.VERTICAL)
        )

        binding.floatingActionButton.setOnClickListener {
            if (auth.currentUser != null){
                val action = ObavijestiFragmentDirections.actionObavijestiNavDrawerToMenuDodajNovuObavijest()
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(),"Nažalost ne možete dodavati članke u rubrici Obavijesti.",
                Toast.LENGTH_LONG)
                    .show()
            }
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        val query: Query = collectionReference
        val tableRecyclerOptions: FirestoreRecyclerOptions<ObavijestiTable> =
            FirestoreRecyclerOptions.Builder<ObavijestiTable>()
                .setQuery(query, ObavijestiTable::class.java)
                .build()
        obavijestiAdapter = ObavijestiAdapter(tableRecyclerOptions)

        binding.recyclerViewObavijesti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewObavijesti.adapter = obavijestiAdapter
    }

    override fun onStart() {
        super.onStart()
        obavijestiAdapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        obavijestiAdapter!!.stopListening()
    }

}
