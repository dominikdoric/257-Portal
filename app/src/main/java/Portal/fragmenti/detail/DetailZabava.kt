package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailZabavaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailZabava: Fragment(R.layout.detail_zabava) {

    private lateinit var binding: DetailZabavaBinding
    private val args by navArgs<DetailZabavaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailZabavaBinding.bind(view)

        binding.naslov.text = args.zabavaArgs.zabavaNaslov
        binding.clanak.text = args.zabavaArgs.zabavaClanak

    }

}