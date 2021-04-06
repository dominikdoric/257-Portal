package Portal.fragmenti.adminPrijava

import Portal.a257.R
import Portal.a257.databinding.AdminPrijavaOglasnikBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class AdminPrijavaOglasnikFragment: Fragment(R.layout.admin_prijava_oglasnik) {

    private lateinit var binding: AdminPrijavaOglasnikBinding
    private val args by navArgs<AdminPrijavaOglasnikFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPrijavaOglasnikBinding.bind(view)

        binding.gumbPrijavaAdminPrijaviSe.setOnClickListener {
            val korisnickoIme = binding.etPrijavaAdminKorisnickoIme.text.toString()
            val lozinka = binding.etPrijavaAdminLozinka.text.toString()
            val token = binding.etPrijavaAdminToken.text.toString()

            if(korisnickoIme == "Dominik" && token == "token" && lozinka == "lozinka"){
                val action = AdminPrijavaOglasnikFragmentDirections.actionAdminPrijavaOglasnikFragmentToUpdateDeleteOglasnikFragment(args.currentOglasnik)
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