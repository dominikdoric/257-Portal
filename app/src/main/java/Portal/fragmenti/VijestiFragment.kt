package Portal.fragmenti

import Portal.a257.R
import Portal.adapter.VijestiAdapter
import Portal.viewModel.VijestiViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.vijesti_fragment.*
import kotlinx.android.synthetic.main.vijesti_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class VijestiFragment : Fragment() {

    private lateinit var mVijestiViewModel: VijestiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vijesti_fragment, container, false)

        //RecyclerView
        val adapter = VijestiAdapter()
        val recyclerVijesti = view.recyclerViewVijesti
        recyclerVijesti.adapter = adapter
        recyclerVijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mVijestiViewModel = ViewModelProvider(this).get(VijestiViewModel::class.java)
        mVijestiViewModel.readAllDataVijesti.observe(viewLifecycleOwner, Observer { vijesti ->
            adapter.setData(vijesti)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewVijesti.addItemDecoration(
            DividerItemDecoration
                (recyclerViewVijesti.context, DividerItemDecoration.VERTICAL)
        )
    }
    /*
    activity?.supportFragmentManager?.beginTransaction()
        ?.replace(R.id.frameLayout_host, vijestiDetailFragment)
        ?.addToBackStack(null)
        ?.commit()*/
    //childFragmentManager.beginTransaction().apply {
    //  replace(R.id.frameLayout_host, zabavaDetailFragment)
    //commit()
}
