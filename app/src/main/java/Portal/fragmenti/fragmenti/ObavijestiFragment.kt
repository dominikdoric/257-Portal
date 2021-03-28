package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.adapter.ObavijestiAdapter
import Portal.viewModel.ObavijestiViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.obavijesti_fragment.*
import kotlinx.android.synthetic.main.obavijesti_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

@AndroidEntryPoint
class ObavijestiFragment : Fragment() {

    private val mObavijestiViewModel: ObavijestiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.obavijesti_fragment, container, false)

        //RecyclerView
        val adapter = ObavijestiAdapter()
        val recyclerObavijesti = view.recyclerViewObavijesti
        recyclerObavijesti.adapter = adapter
        recyclerObavijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mObavijestiViewModel.readAllDataObavijesti.observe(
            viewLifecycleOwner,
            Observer { obavijesti ->
                adapter.setData(obavijesti)
            })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewObavijesti.addItemDecoration(
            DividerItemDecoration
                (recyclerViewObavijesti.context, DividerItemDecoration.VERTICAL)
        )
    }
}
