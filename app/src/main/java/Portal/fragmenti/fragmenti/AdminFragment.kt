package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.AdminFragmentBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AdminFragment: Fragment(R.layout.admin_fragment) {

    private lateinit var binding: AdminFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminFragmentBinding.bind(view)

        binding.gumbAdminPrijaviSe.setOnClickListener {
            if (binding.etAdminKorisnickoIme.text.toString().isEmpty()){
                binding.etAdminKorisnickoIme.error = "Ovo polje je obavezno!"
            }else if (binding.etAdminLozinka.text.toString().isEmpty()){
                binding.etAdminLozinka.error = "Ovo polje je obavezno!"
            }else if(binding.etAdminToken.text.toString().isEmpty()){
                binding.etAdminToken.error = "Ovo polje je obavezno!"
            }else{
                val action = AdminFragmentDirections.actionMenuAdminToAdminPrijavljenFragment()
                findNavController().navigate(action)
                Toast.makeText(requireContext(),"Upješno ste se prijavili!",Toast.LENGTH_LONG).show()
            }
        }

    }


}