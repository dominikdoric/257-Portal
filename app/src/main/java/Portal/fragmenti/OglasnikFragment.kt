package Portal.fragmenti

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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.oglasnik_fragment.*
import kotlinx.android.synthetic.main.oglasnik_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

@AndroidEntryPoint
class OglasnikFragment : Fragment() {

    private val mOglasnikViewModel: OglasnikViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.oglasnik_fragment, container, false)

        //RecyclerView
        val adapter = OglasnikAdapter()
        val recyclerOglasnik = view.recyclerViewOglasnik
        recyclerOglasnik.adapter = adapter
        recyclerOglasnik.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mOglasnikViewModel.readAllDataOglasnik.observe(viewLifecycleOwner, Observer { oglasnik ->
            adapter.setData(oglasnik)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewOglasnik.addItemDecoration(
            DividerItemDecoration
                (recyclerViewOglasnik.context, DividerItemDecoration.VERTICAL)
        )
    }
}