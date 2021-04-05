package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiObavijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiObavijesti: Fragment(R.layout.admin_potvrdi_obavijesti) {

    private val args by navArgs<AdminPotvrdiObavijestiArgs>()
    private lateinit var binding: AdminPotvrdiObavijestiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiObavijestiBinding.bind(view)

        binding.odobriAdminObavijestiNaslov.setText(args.adminObavijestiArgs.obavijestiNaslov)
        binding.odobriAdminObavijestiClanak.setText(args.adminObavijestiArgs.obavijestiClanak)

        binding.gumbAdminOdobriObavijesti.setOnClickListener {
            odobriObavijest()
        }
    }

    private fun odobriObavijest() {
        TODO("Not yet implemented")
    }


}