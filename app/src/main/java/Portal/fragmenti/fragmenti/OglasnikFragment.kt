package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.OglasnikFragmentBinding
import Portal.adapter.OglasnikAdapter
import Portal.viewModel.OglasnikViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OglasnikFragment : Fragment(R.layout.oglasnik_fragment) {

    private val mOglasnikViewModel: OglasnikViewModel by viewModels()
    private lateinit var binding: OglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OglasnikFragmentBinding.bind(view)

        binding.recyclerViewOglasnik.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewOglasnik.context, DividerItemDecoration.VERTICAL)
        )

        //RecyclerView
        val adapter = OglasnikAdapter()
        val recyclerOglasnik = binding.recyclerViewOglasnik
        recyclerOglasnik.adapter = adapter
        recyclerOglasnik.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mOglasnikViewModel.readAllDataOglasnik.observe(viewLifecycleOwner, Observer { oglasnik ->
            adapter.setData(oglasnik)
        })

    }
}