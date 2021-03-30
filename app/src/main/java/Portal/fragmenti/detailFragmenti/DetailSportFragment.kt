package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailSportFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailSportFragment : Fragment(R.layout.detail_sport_fragment) {

    private val args by navArgs<DetailSportFragmentArgs>()
    private lateinit var binding: DetailSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailSportFragmentBinding.bind(view)

        binding.detailSportNaslov.text = args.sportData.sportNaslov
        binding.detailSportClanak.text = args.sportData.sportClanak
    }

}