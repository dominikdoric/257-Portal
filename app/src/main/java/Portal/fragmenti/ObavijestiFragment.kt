package Portal.fragmenti

import Portal.DetailFragmenti.DetailObavijestiFragment
import Portal.a257.R
import Portal.adapter.ObavijestiAdapter
import Portal.viewModel.ObavijestiViewModel
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
import kotlinx.android.synthetic.main.obavijesti_fragment.*
import kotlinx.android.synthetic.main.obavijesti_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class ObavijestiFragment: Fragment(),ObavijestiAdapter.OnItemClickListener {

    private lateinit var mObavijestiViewModel: ObavijestiViewModel
    val detailObavijestiFragment = DetailObavijestiFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.obavijesti_fragment,container,false)

        //RecyclerView
        val adapter = ObavijestiAdapter(this)
        val recyclerObavijesti = view.recyclerViewObavijesti
        recyclerObavijesti.adapter = adapter
        recyclerObavijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mObavijestiViewModel = ViewModelProvider(this).get(ObavijestiViewModel::class.java)
        mObavijestiViewModel.readAllDataObavijesti.observe(viewLifecycleOwner, Observer { obavijesti ->
            adapter.setData(obavijesti)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewObavijesti.addItemDecoration(DividerItemDecoration
            (recyclerViewObavijesti.context,DividerItemDecoration.VERTICAL))
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "Item  $position clicked", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout_host,detailObavijestiFragment)
            ?.addToBackStack(null)
            ?.commit()
        //childFragmentManager.beginTransaction().apply {
        //  replace(R.id.frameLayout_host, zabavaDetailFragment)
        //commit()
    }

}