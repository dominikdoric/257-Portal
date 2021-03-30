package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PriceCitateljaFragmentBinding
import Portal.adapter.PriceCitateljaAdapter
import Portal.viewModel.PriceCitateljaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PriceCitateljaFragment : Fragment(R.layout.price_citatelja_fragment) {

    private val mPriceCitateljaViewModel: PriceCitateljaViewModel by viewModels()

    private lateinit var binding: PriceCitateljaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PriceCitateljaFragmentBinding.bind(view)

        binding.recyclerViewPriceCitatelja.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewPriceCitatelja.context,
                DividerItemDecoration.VERTICAL
            )
        )

        //RecyclerView
        val adapter = PriceCitateljaAdapter()
        val recyclerPriceCitatelja = binding.recyclerViewPriceCitatelja
        recyclerPriceCitatelja.adapter = adapter
        recyclerPriceCitatelja.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        mPriceCitateljaViewModel.readAllDataPriceCitatelja.observe(
            viewLifecycleOwner,
            Observer { priceCitatelja ->
                adapter.setData(priceCitatelja)
            })

    }

}