package Portal.fragmenti.adminPrijava

import Portal.a257.R
import Portal.a257.databinding.AdminPrijavaPriceCitetaljaBinding
import Portal.a257.databinding.AdminPrijavaSportBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class AdminPrijavaPriceCitateljaFragment: Fragment(R.layout.admin_prijava_price_citetalja) {

    private lateinit var binding: AdminPrijavaPriceCitetaljaBinding
    private val args by navArgs<AdminPrijavaPriceCitateljaFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPrijavaPriceCitetaljaBinding.bind(view)

        binding.gumbPrijavaAdminPrijaviSe.setOnClickListener {
            val korisnickoIme = binding.etPrijavaAdminKorisnickoIme.text.toString()
            val lozinka = binding.etPrijavaAdminLozinka.text.toString()
            val token = binding.etPrijavaAdminToken.text.toString()

            if(korisnickoIme == "Dominik" && token == "token" && lozinka == "lozinka"){
                val action = AdminPrijavaPriceCitateljaFragmentDirections.actionAdminPrijavaPriceCitateljaFragmentToUpdateDeletePriceCitateljaFragment(args.currentPriceCitatelja)
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