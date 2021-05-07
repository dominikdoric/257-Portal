package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePriceCitateljaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class UpdateDeletePriceCitatelja: Fragment(R.layout.update_delete_price_citatelja) {

    private lateinit var binding: UpdateDeletePriceCitateljaBinding
    private val args by navArgs<UpdateDeletePriceCitateljaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePriceCitateljaBinding.bind(view)

        binding.naslov.setText(args.updateCitateljeArgs.priceCitateljaNaslov)
        binding.clanak.setText(args.updateCitateljeArgs.priceCitateljaClanak)

        binding.gumbAzuriraj.setOnClickListener {
            azurirajItem()
        }

        binding.gumbObrisi.setOnClickListener {
            obrisiItem()
        }

    }

    private fun obrisiItem() {

    }

    private fun azurirajItem() {

    }
}