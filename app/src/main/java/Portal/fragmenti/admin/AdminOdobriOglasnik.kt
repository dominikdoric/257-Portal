package Portal.fragmenti.admin

import Portal.a257.R
import Portal.a257.databinding.AdminOdobriOglasnikBinding
import Portal.adapter.OglasnikAdapter
import Portal.viewModel.OglasnikViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminOdobriOglasnik: Fragment(R.layout.admin_odobri_oglasnik) {

    private val mOglasnikViewModel: OglasnikViewModel by viewModels()
    private lateinit var binding: AdminOdobriOglasnikBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminOdobriOglasnikBinding.bind(view)

        //RecyclerView
        val adapter = OglasnikAdapter()
        val recyclerOdobriOglasnik = binding.recyclerViewOdobriOglasnik
        recyclerOdobriOglasnik.adapter = adapter
        recyclerOdobriOglasnik.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mOglasnikViewModel.readAllDataOglasnik.observe(viewLifecycleOwner, Observer { oglasnik ->
            adapter.setData(oglasnik)
        })
    }

}