package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.a257.databinding.ZabavaFragmentBinding
import Portal.adapter.SportAdapter
import Portal.adapter.ZabavaAdapter
import Portal.viewModel.SportViewModel
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.naslovnica_fragment.*
import kotlinx.android.synthetic.main.sport_fragment.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class NaslovnicaFragment : Fragment(R.layout.naslovnica_fragment) {

    private val sportViewModel: SportViewModel by viewModels()
    private val zabavaViewModel: ZabavaViewModel by viewModels()
    private lateinit var sportBinding: SportFragmentBinding
    private lateinit var zabavaBinding: ZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sportBinding = SportFragmentBinding.bind(view)
        zabavaBinding = ZabavaFragmentBinding.bind(view)

        //RecyclerView
        val adapterSport = SportAdapter()
        val recyclerSport = recyclerViewNaslovnica
        recyclerSport.adapter = adapterSport
        recyclerSport.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        sportViewModel.readAllDataSport.observe(viewLifecycleOwner,{ sport ->
            adapterSport.setData(sport)
        })

        //RecyclerView
        val adapterZabava = ZabavaAdapter()
        val recyclerZabava = recyclerViewNaslovnica
        recyclerZabava.adapter = adapterZabava
        recyclerZabava.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        zabavaViewModel.readAllDataZabava.observe(viewLifecycleOwner,{ zabava ->
            adapterZabava.setData(zabava)
        })

    }


}