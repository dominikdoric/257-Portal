package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.a257.databinding.ZabavaFragmentBinding
import Portal.adapter.ObavijestiAdapter
import Portal.adapter.SportAdapter
import Portal.adapter.ZabavaAdapter
import Portal.viewModel.ObavijestiViewModel
import Portal.viewModel.SportViewModel
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.naslovnica_fragment.*
import kotlinx.android.synthetic.main.obavijesti_fragment.*
import kotlinx.android.synthetic.main.sport_fragment.*
import kotlinx.android.synthetic.main.zabava_fragment.*

@AndroidEntryPoint
class NaslovnicaFragment : Fragment(R.layout.naslovnica_fragment) {

    private val sportViewModel: SportViewModel by viewModels()
    private val zabavaViewModel: ZabavaViewModel by viewModels()
    private val obavijestiViewModel: ObavijestiViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //RecyclerViewObavijesti
        val adapterObavijesti = ObavijestiAdapter()
        val recyclerObavijesti = recyclerViewNaslovnica
        recyclerObavijesti.adapter = adapterObavijesti
        recyclerObavijesti.layoutManager = LinearLayoutManager(requireContext())

        //RecyclerViewSport
        val adapterSport = SportAdapter()
        val recyclerSport = recyclerViewNaslovnica
        recyclerSport.adapter = adapterSport
        recyclerSport.layoutManager = LinearLayoutManager(requireContext())

        //RecyclerViewZabava
        val adapterZabava = ZabavaAdapter()
        val recyclerZabava = recyclerViewNaslovnica
        recyclerZabava.adapter = adapterZabava
        recyclerZabava.layoutManager = LinearLayoutManager(requireContext())


        //RasporedViewModel
        zabavaViewModel.readAllDataZabava.observe(viewLifecycleOwner,{ zabava ->
            adapterZabava.setData(zabava)
        })

        //RasporedViewModel
        obavijestiViewModel.readAllDataObavijesti.observe(viewLifecycleOwner,{ obavijesti ->
            adapterObavijesti.setData(obavijesti)
        })

        //RasporedViewModel
        sportViewModel.readAllDataSport.observe(viewLifecycleOwner,{ sport ->
            adapterSport.setData(sport)
        })

    }

}