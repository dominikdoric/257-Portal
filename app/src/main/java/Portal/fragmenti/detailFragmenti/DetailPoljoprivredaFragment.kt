package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailPoljoprivredaFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailPoljoprivredaFragment: Fragment(R.layout.detail_poljoprivreda_fragment) {

    private val args by navArgs<DetailPoljoprivredaFragmentArgs>()
    private lateinit var binding: DetailPoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailPoljoprivredaFragmentBinding.bind(view)

        binding.detailPoljoprivredaNaslov.text = args.detailPoljoprivredaArgs.poljoprivredaNaslov
        binding.detailPoljoprivredaClanak.text = args.detailPoljoprivredaArgs.poljoprivredaClanak
    }

}