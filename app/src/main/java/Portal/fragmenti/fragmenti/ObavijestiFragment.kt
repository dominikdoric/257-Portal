package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ObavijestiFragmentBinding
import Portal.adapter.ObavijestiAdapter
import Portal.viewModel.ObavijestiViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ObavijestiFragment : Fragment(R.layout.obavijesti_fragment) {

    private val mObavijestiViewModel: ObavijestiViewModel by viewModels()
    private lateinit var binding: ObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ObavijestiFragmentBinding.bind(view)


        binding.recyclerViewObavijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewObavijesti.context, DividerItemDecoration.VERTICAL)
        )

        //RecyclerView
        val adapter = ObavijestiAdapter()
        val recyclerObavijesti = binding.recyclerViewObavijesti
        recyclerObavijesti.adapter = adapter
        recyclerObavijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mObavijestiViewModel.readAllDataObavijesti.observe(
            viewLifecycleOwner,
            Observer { obavijesti ->
                adapter.setData(obavijesti)
            })

    }
}
