package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiZabavuBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiZabavu: Fragment(R.layout.admin_potvrdi_zabavu) {

    private val args by navArgs<AdminPotvrdiZabavuArgs>()
    private lateinit var binding: AdminPotvrdiZabavuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiZabavuBinding.bind(view)

        binding.odobriAdminZabavaNaslov.setText(args.adminZabavaArgs.zabavaNaslov)
        binding.odobriAdminZabavaClanak.setText(args.adminZabavaArgs.zabavaClanak)

        binding.gumbAdminOdobriZabava.setOnClickListener {
            odobriZabavu()
        }
    }

    private fun odobriZabavu() {
        TODO("Not yet implemented")
    }

}