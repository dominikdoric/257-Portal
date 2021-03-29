package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_price_citatelja_fragment.view.*

class DetailPriceCitateljaFragment : Fragment() {

    private val args by navArgs<DetailPriceCitateljaFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_price_citatelja_fragment, container, false)

        view.detailPriceCitateljaNaslov.setText(args.priceCitateljaData.priceCitateljaNaslov)
        view.detailPriceCitateljaClanak.setText(args.priceCitateljaData.priceCitateljaClanak)

        return view
    }

}