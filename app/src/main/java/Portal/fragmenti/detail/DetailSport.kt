package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailSportBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailSport: Fragment(R.layout.detail_sport) {

    private lateinit var binding:DetailSportBinding
    private val args by navArgs<DetailSportArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailSportBinding.bind(view)

        binding.naslov.text = args.sportArgs.naslov
        binding.clanak.text = args.sportArgs.clanak
    }
}