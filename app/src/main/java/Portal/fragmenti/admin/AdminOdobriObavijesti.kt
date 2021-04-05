package Portal.fragmenti.admin

import Portal.a257.R
import Portal.a257.databinding.AdminOdobriObavijestBinding
import Portal.adapter.ObavijestiAdapter
import Portal.viewModel.ObavijestiViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminOdobriObavijesti: Fragment(R.layout.admin_odobri_obavijest) {

    private val mObavijestiViewModel: ObavijestiViewModel by viewModels()
    private lateinit var binding: AdminOdobriObavijestBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminOdobriObavijestBinding.bind(view)

        //RecyclerView
        val adapter = ObavijestiAdapter()
        val recyclerOdobriObavijesti = binding.recyclerViewOdobriObavijesti
        recyclerOdobriObavijesti.adapter = adapter
        recyclerOdobriObavijesti.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mObavijestiViewModel.readAllDataObavijesti.observe(viewLifecycleOwner, Observer { obavijesti ->
            adapter.setData(obavijesti)
        })
    }

}