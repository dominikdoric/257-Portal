package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiSportBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiSport: Fragment(R.layout.admin_potvrdi_sport) {

    private val args by navArgs<AdminPotvrdiSportArgs>()
    private lateinit var binding: AdminPotvrdiSportBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiSportBinding.bind(view)

        binding.odobriAdminSportNaslov.setText(args.adminSportArgs.sportNaslov)
        binding.odobriAdminSportClanak.setText(args.adminSportArgs.sportClanak)

        binding.gumbAdminOdobriSport.setOnClickListener {
            odobriSport()
        }
    }

    private fun odobriSport() {
        TODO("Not yet implemented")
    }

}