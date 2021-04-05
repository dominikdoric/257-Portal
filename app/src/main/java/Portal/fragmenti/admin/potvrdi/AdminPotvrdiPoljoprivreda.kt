package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiPoljoprivredaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiPoljoprivreda: Fragment(R.layout.admin_potvrdi_poljoprivreda) {

    private val args by navArgs<AdminPotvrdiPoljoprivredaArgs>()
    private lateinit var binding: AdminPotvrdiPoljoprivredaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiPoljoprivredaBinding.bind(view)

        binding.odobriAdminPoljoprivredaNaslov.setText(args.adminPoljoprivredaArgs.poljoprivredaNaslov)
        binding.odobriAdminPoljoprivredaClanak.setText(args.adminPoljoprivredaArgs.poljoprivredaClanak)

        binding.gumbAdminOdobriPoljoprivreda.setOnClickListener {
            odobriPoljoprivredu()
        }
    }

    private fun odobriPoljoprivredu() {
        TODO("Not yet implemented")
    }

}