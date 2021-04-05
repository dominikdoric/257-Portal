package Portal.fragmenti.admin.odobri

import Portal.a257.R
import Portal.a257.databinding.AdminOdobriZabavaBinding
import Portal.adapter.ZabavaAdapter
import Portal.adapter.adminAdapter.AdminZabavaAdapter
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminOdobriZabavu: Fragment(R.layout.admin_odobri_zabava) {

    private val mZabavaViewModel: ZabavaViewModel by viewModels()
    private lateinit var binding: AdminOdobriZabavaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminOdobriZabavaBinding.bind(view)

        //RecyclerView
        val adapter = AdminZabavaAdapter()
        val recyclerOdobriZabava = binding.recyclerViewOdobriZabava
        recyclerOdobriZabava.adapter = adapter
        recyclerOdobriZabava.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mZabavaViewModel.readAllDataZabava.observe(viewLifecycleOwner, Observer { zabava ->
            adapter.setData(zabava)
        })
    }
}