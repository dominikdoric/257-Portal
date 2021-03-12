package Portal.fragmenti

import Portal.DetailFragmenti.DetailOglasnikFragment
import Portal.a257.R
import Portal.adapter.OglasnikAdapter
import Portal.viewModel.OglasnikViewModel
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
import kotlinx.android.synthetic.main.oglasnik_fragment.*
import kotlinx.android.synthetic.main.oglasnik_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class OglasnikFragment: Fragment(),OglasnikAdapter.OnItemClickListener,OglasnikAdapter.OnItemLongClickListener {

    private lateinit var mOglasnikViewModel: OglasnikViewModel
    val detailOglasnikFragment = DetailOglasnikFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.oglasnik_fragment,container,false)

        //RecyclerView
        val adapter = OglasnikAdapter(this,this)
        val recyclerOglasnik = view.recyclerViewOglasnik
        recyclerOglasnik.adapter = adapter
        recyclerOglasnik.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mOglasnikViewModel = ViewModelProvider(this).get(OglasnikViewModel::class.java)
        mOglasnikViewModel.readAllDataOglasnik.observe(viewLifecycleOwner, Observer { oglasnik ->
            adapter.setData(oglasnik)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewOglasnik.addItemDecoration(DividerItemDecoration
            (recyclerViewOglasnik.context,DividerItemDecoration.VERTICAL))
    }

    override fun onItemClick(position: Int,naslovOglasnik: String,clanakOglasnik: String,cijenaOglasnik: String,lokacijaOglasnik: String,brojOglasnik: String) {
        Toast.makeText(requireContext(), "Item  $position clicked" +
                "\nItem  $naslovOglasnik clicked" +
                "\nItem  $clanakOglasnik clicked" +
                "\nItem  $cijenaOglasnik clicked" +
                "\nItem  $lokacijaOglasnik clicked" +
                "\nItem  $brojOglasnik clicked", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout_host,detailOglasnikFragment)
            ?.addToBackStack(null)
            ?.commit()
        //childFragmentManager.beginTransaction().apply {
        //  replace(R.id.frameLayout_host, zabavaDetailFragment)
        //commit()
    }

    override fun onItemLongClick(position: Int) {
        deleteRow()
    }

    private fun deleteRow() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->

        }
        builder.setNegativeButton("No") { _, _ ->}
        builder.setTitle("Delete?")
        builder.setMessage("Are you sure you want to delete?")
        builder.create().show()
    }

}