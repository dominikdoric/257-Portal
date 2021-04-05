package Portal.fragmenti.admin

import Portal.a257.R
import Portal.a257.databinding.AdminOdobriPoljoprivredaBinding
import Portal.adapter.PoljoprivredaAdapter
import Portal.viewModel.PoljoprivredaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminOdobriPoljoprivreda: Fragment(R.layout.admin_odobri_poljoprivreda) {

    private val mPoljoprivredaViewModel: PoljoprivredaViewModel by viewModels()
    private lateinit var binding: AdminOdobriPoljoprivredaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminOdobriPoljoprivredaBinding.bind(view)

        //RecyclerView
        val adapter = PoljoprivredaAdapter()
        val recyclerOdobriPoljoprivreda = binding.recyclerViewOdobriPoljoprivreda
        recyclerOdobriPoljoprivreda.adapter = adapter
        recyclerOdobriPoljoprivreda.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mPoljoprivredaViewModel.readAllDataPoljoprivreda.observe(viewLifecycleOwner, Observer { poljoprivreda ->
            adapter.setData(poljoprivreda)
        })
    }

}