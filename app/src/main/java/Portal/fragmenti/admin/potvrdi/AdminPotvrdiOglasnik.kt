package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiOglasnikBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiOglasnik: Fragment(R.layout.admin_potvrdi_oglasnik) {

    private val args by navArgs<AdminPotvrdiOglasnikArgs>()
    private lateinit var binding: AdminPotvrdiOglasnikBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiOglasnikBinding.bind(view)

        binding.odobriAdminOglasnikNaslov.setText(args.adminOglasnikArgs.oglasnikNaslov)
        binding.odobriAdminOglasnikClanak.setText(args.adminOglasnikArgs.oglasnikClanak)
        binding.odobriAdminOglasnikBroj.setText(args.adminOglasnikArgs.oglasnikBroj)
        binding.odobriAdminOglasnikCijena.setText(args.adminOglasnikArgs.oglasnikCijena)
        binding.odobriAdminOglasnikLokacija.setText(args.adminOglasnikArgs.oglasnikLokacija)

        binding.gumbAdminOdobriOglasnik.setOnClickListener {
            odobriOglas()
        }
    }

    private fun odobriOglas() {
        TODO("Not yet implemented")
    }

}