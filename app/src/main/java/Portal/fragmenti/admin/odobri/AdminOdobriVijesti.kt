package Portal.fragmenti.admin.odobri

import Portal.a257.R
import Portal.a257.databinding.AdminOdobriVijestiBinding
import Portal.adapter.VijestiAdapter
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminOdobriVijesti: Fragment(R.layout.admin_odobri_vijesti) {

    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: AdminOdobriVijestiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminOdobriVijestiBinding.bind(view)

        //RecyclerView
        val adapter = VijestiAdapter()
        val recyclerOdobriVijesti = binding.recyclerViewOdobriVijesti
        recyclerOdobriVijesti.adapter = adapter
        recyclerOdobriVijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mVijestiViewModel.readAllDataVijesti.observe(viewLifecycleOwner, Observer { vijesti ->
            adapter.setData(vijesti)
        })
    }

}