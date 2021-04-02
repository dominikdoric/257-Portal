package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PoljoprivredaFragmentBinding
import Portal.adapter.PoljoprivredaAdapter
import Portal.viewModel.PoljoprivredaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class PoljoprivredaFragment: Fragment(R.layout.poljoprivreda_fragment) {

    private val poljoprivredaViewModel: PoljoprivredaViewModel by viewModels()
    private lateinit var binding: PoljoprivredaFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PoljoprivredaFragmentBinding.bind(view)

        binding.recyclerViewPoljoprivreda.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewPoljoprivreda.context, DividerItemDecoration.VERTICAL
            )
        )

        //RecyclerView
        val adapter = PoljoprivredaAdapter()
        val recyclerPoljoprivreda = binding.recyclerViewPoljoprivreda
        recyclerPoljoprivreda.adapter = adapter
        recyclerPoljoprivreda.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        poljoprivredaViewModel.readAllDataPoljoprivreda.observe(viewLifecycleOwner, Observer { poljoprivreda ->
            adapter.setData(poljoprivreda)
        })

    }

}