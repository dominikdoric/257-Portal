package Portal.fragmenti.admin.potvrdi

import Portal.a257.R
import Portal.a257.databinding.AdminPotvrdiPriceCitateljaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminPotvrdiPriceCitatelja: Fragment(R.layout.admin_potvrdi_price_citatelja) {

    private val args by navArgs<AdminPotvrdiPriceCitateljaArgs>()
    private lateinit var binding: AdminPotvrdiPriceCitateljaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPotvrdiPriceCitateljaBinding.bind(view)

        binding.odobriAdminPriceCitateljaNaslov.setText(args.adminPriceArgs.priceCitateljaNaslov)
        binding.odobriAdminPriceCitateljaClanak.setText(args.adminPriceArgs.priceCitateljaClanak)

        binding.gumbAdminOdobriPriceCitatelja.setOnClickListener {
            odobriPricuCitatelja()
        }
    }

    private fun odobriPricuCitatelja() {
        TODO("Not yet implemented")
    }

}