package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.AdminFragmentBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class AdminFragment: Fragment(R.layout.admin_fragment) {

    private lateinit var binding: AdminFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminFragmentBinding.bind(view)

        binding.gumbAdminPrijaviSe.setOnClickListener {
            val korisnickoIme = binding.etAdminKorisnickoIme.text.toString()
            val token = binding.etAdminToken.text.toString()
            val lozinka = binding.etAdminLozinka.text.toString()
            if(korisnickoIme == "Dominik" && token == "token" && lozinka == "lozinka"){
                Toast.makeText(requireContext(),"Upješno ste se prijavili!",Toast.LENGTH_LONG).show()
            }
            else if (binding.etAdminKorisnickoIme.text.toString().isEmpty()){
                binding.etAdminKorisnickoIme.error = "Ovo polje je obavezno!"
            }else if (binding.etAdminLozinka.text.toString().isEmpty()){
                binding.etAdminLozinka.error = "Ovo polje je obavezno!"
            }else if(binding.etAdminToken.text.toString().isEmpty()){
                binding.etAdminToken.error = "Ovo polje je obavezno!"
            }else{
                Toast.makeText(requireContext(),"Unjeli ste krive podatke!",Toast.LENGTH_LONG).show()
            }
        }

    }


}