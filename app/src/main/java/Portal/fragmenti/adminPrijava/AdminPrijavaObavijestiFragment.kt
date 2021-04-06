package Portal.fragmenti.adminPrijava

import Portal.a257.R
import Portal.a257.databinding.AdminPrijavaObavijestiBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class AdminPrijavaObavijestiFragment: Fragment(R.layout.admin_prijava_obavijesti) {

    private lateinit var binding: AdminPrijavaObavijestiBinding
    private val args by navArgs<AdminPrijavaObavijestiFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPrijavaObavijestiBinding.bind(view)

        binding.gumbPrijavaAdminPrijaviSe.setOnClickListener {
            val korisnickoIme = binding.etPrijavaAdminKorisnickoIme.text.toString()
            val lozinka = binding.etPrijavaAdminLozinka.text.toString()
            val token = binding.etPrijavaAdminToken.text.toString()

            if(korisnickoIme == "Dominik" && token == "token" && lozinka == "lozinka"){
                val action = AdminPrijavaObavijestiFragmentDirections.actionAdminPrijavaObavijestiFragmentToUpdateDeleteObavijestiFragment2(args.currentObavijesti)
                findNavController().navigate(action)
            }else if (binding.etPrijavaAdminKorisnickoIme.text.toString().isEmpty()){
                binding.etPrijavaAdminKorisnickoIme.error = "Ovo polje je obavezno!"
            }else if (binding.etPrijavaAdminLozinka.text.toString().isEmpty()){
                binding.etPrijavaAdminLozinka.error = "Ovo polje je obavezno!"
            }else if(binding.etPrijavaAdminToken.text.toString().isEmpty()){
                binding.etPrijavaAdminToken.error = "Ovo polje je obavezno!"
            }else{
                Toast.makeText(requireContext(),"Unjeli ste krive podatke!", Toast.LENGTH_LONG).show()
            }
        }
    }

}