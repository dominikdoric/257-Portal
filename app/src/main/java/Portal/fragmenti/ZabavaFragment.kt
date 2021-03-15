package Portal.fragmenti

import Portal.a257.R
import Portal.adapter.ZabavaAdapter
import Portal.viewModel.ZabavaViewModel
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
import kotlinx.android.synthetic.main.zabava_fragment.*
import kotlinx.android.synthetic.main.zabava_fragment.view.*

class ZabavaFragment : Fragment(), ZabavaAdapter.OnItemClickListener,
    ZabavaAdapter.OnItemLongClickListener {

    private lateinit var mZabavaViewModel: ZabavaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zabava_fragment, container, false)

        //RecyclerView
        val adapter = ZabavaAdapter(this, this)
        val recyclerZabava = view.recyclerViewZabava
        recyclerZabava.adapter = adapter
        recyclerZabava.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mZabavaViewModel = ViewModelProvider(this).get(ZabavaViewModel::class.java)
        mZabavaViewModel.readAllDataZabava.observe(viewLifecycleOwner, Observer { zabava ->
            adapter.setData(zabava)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewZabava.addItemDecoration(
            DividerItemDecoration
                (recyclerViewZabava.context, DividerItemDecoration.VERTICAL)
        )

    }

    override fun onItemClick(position: Int, naslovZabava: String, clanakZabava: String) {
        Toast.makeText(
            requireContext(), "Item  $position clicked" +
                    "\nItem  $naslovZabava clicked" +
                    "\nItem  $clanakZabava clicked", Toast.LENGTH_SHORT
        ).show()
        activity?.supportFragmentManager?.beginTransaction()
                /*
            ?.replace(R.id.frameLayout_host, zabavaDetailFragment)
            ?.addToBackStack(null)
            ?.commit()*/
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
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete?")
        builder.setMessage("Are you sure you want to delete?")
        builder.create().show()
    }
}