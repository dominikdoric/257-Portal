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
    }
}