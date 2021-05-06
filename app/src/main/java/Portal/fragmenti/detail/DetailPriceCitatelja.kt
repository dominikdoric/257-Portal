package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailPriceCitateljaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailPriceCitatelja: Fragment(R.layout.detail_price_citatelja) {

    private lateinit var binding: DetailPriceCitateljaBinding
    private val args by navArgs<DetailPriceCitateljaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailPriceCitateljaBinding.bind(view)

        binding.naslov.text = args.priceCitateljaArgs.priceCitateljaNaslov
        binding.clanak.text = args.priceCitateljaArgs.priceCitateljaClanak

    }
}