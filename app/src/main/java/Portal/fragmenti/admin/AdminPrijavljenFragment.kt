package Portal.fragmenti.admin

import Portal.a257.R
import Portal.a257.databinding.AdminPrijavljenFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AdminPrijavljenFragment: Fragment(R.layout.admin_prijavljen_fragment) {

    private lateinit var binding: AdminPrijavljenFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPrijavljenFragmentBinding.bind(view)

       binding.gumbAdminZabava.setOnClickListener {
           val action =
               AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriZabavu()
           findNavController().navigate(action)
       }

        binding.gumbAdminObavijest.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriObavijesti()
            findNavController().navigate(action)
        }

        binding.gumbAdminOglasnik.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriOglasnik()
            findNavController().navigate(action)
        }

        binding.gumbAdminPoljoprivreda.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriPoljoprivreda()
            findNavController().navigate(action)
        }

        binding.gumbAdminPrice.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriPriceCitatelja()
            findNavController().navigate(action)
        }

        binding.gumbAdminSport.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriSport()
            findNavController().navigate(action)
        }

        binding.gumbAdminVijest.setOnClickListener {
            val action = AdminPrijavljenFragmentDirections.actionAdminPrijavljenFragmentToAdminOdobriVijesti()
            findNavController().navigate(action)
        }

    }
}