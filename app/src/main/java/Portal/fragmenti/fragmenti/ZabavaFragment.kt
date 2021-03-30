package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ZabavaFragmentBinding
import Portal.adapter.ZabavaAdapter
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ZabavaFragment : Fragment(R.layout.zabava_fragment) {

    private val mZabavaViewModel: ZabavaViewModel by viewModels()

    private lateinit var binding: ZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZabavaFragmentBinding.bind(view)

        binding.recyclerViewZabava.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewZabava.context, DividerItemDecoration.VERTICAL)
        )

        //RecyclerView
        val adapter = ZabavaAdapter()
        val recyclerZabava = binding.recyclerViewZabava
        recyclerZabava.adapter = adapter
        recyclerZabava.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mZabavaViewModel.readAllDataZabava.observe(viewLifecycleOwner, Observer { zabava ->
            adapter.setData(zabava)
        })

    }
}
