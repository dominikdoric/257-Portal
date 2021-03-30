package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.SportFragmentBinding
import Portal.adapter.SportAdapter
import Portal.viewModel.SportViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportFragment : Fragment(R.layout.sport_fragment) {

    private val sportViewModel: SportViewModel by viewModels()

    private lateinit var binding: SportFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SportFragmentBinding.bind(view)

        binding.recyclerViewSport.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewSport.context,DividerItemDecoration.VERTICAL
            )
        )

        //RecyclerView
        val adapter = SportAdapter()
        val recyclerSport = binding.recyclerViewSport
        recyclerSport.adapter = adapter
        recyclerSport.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        sportViewModel.readAllDataSport.observe(viewLifecycleOwner, Observer { sport ->
            adapter.setData(sport)
        })

    }
}