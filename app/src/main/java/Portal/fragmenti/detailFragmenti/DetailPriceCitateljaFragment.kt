package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailPriceCitateljaFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailPriceCitateljaFragment : Fragment(R.layout.detail_price_citatelja_fragment) {

    private val args by navArgs<DetailPriceCitateljaFragmentArgs>()

    private lateinit var binding: DetailPriceCitateljaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailPriceCitateljaFragmentBinding.bind(view)

        binding.detailPriceCitateljaNaslov.text = args.priceCitateljaData.priceCitateljaNaslov
        binding.detailPriceCitateljaClanak.text = args.priceCitateljaData.priceCitateljaClanak
    }

}