package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailPoljoprivredaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class PoljoprivredaDetail: Fragment(R.layout.detail_poljoprivreda) {

    private lateinit var binding: DetailPoljoprivredaBinding
    private val args by navArgs<PoljoprivredaDetailArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailPoljoprivredaBinding.bind(view)

        binding.naslov.text = args.poljoprivredaArgs.poljoprivredaNaslov
        binding.clanak.text = args.poljoprivredaArgs.poljoprivredaClanak
    }
}