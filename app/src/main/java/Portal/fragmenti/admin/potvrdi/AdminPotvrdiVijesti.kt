package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiVijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiVijesti: Fragment(R.layout.admin_potvrdi_vijesti) {

    private val args by navArgs<AdminPotvrdiVijestiArgs>()
    private lateinit var binding: AdminPotvrdiVijestiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiVijestiBinding.bind(view)

        binding.odobriAdminVijestiNaslov.setText(args.adminVijestiArgs.vijestiNaslov)
        binding.odobriAdminVijestiClanak.setText(args.adminVijestiArgs.vijestiClanak)

        binding.gumbAdminOdobriVijesti.setOnClickListener {
            odobriVijest()
        }
    }

    private fun odobriVijest() {
        TODO("Not yet implemented")
    }

}