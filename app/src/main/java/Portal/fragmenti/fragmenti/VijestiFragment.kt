package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.VijestiFragmentBinding
import Portal.adapter.VijestiAdapter
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VijestiFragment : Fragment(R.layout.vijesti_fragment) {

    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: VijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = VijestiFragmentBinding.bind(view)

        binding.recyclerViewVijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewVijesti.context, DividerItemDecoration.VERTICAL)
        )

        //RecyclerView
        val adapter = VijestiAdapter()
        val recyclerVijesti = binding.recyclerViewVijesti
        recyclerVijesti.adapter = adapter
        recyclerVijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mVijestiViewModel.readAllDataVijesti.observe(viewLifecycleOwner, Observer { vijesti ->
            adapter.setData(vijesti)
        })
    }
}
