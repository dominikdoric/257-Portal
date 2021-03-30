package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailSportFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_sport_fragment.view.*

class DetailSportFragment : Fragment(R.layout.detail_sport_fragment) {

    private val args by navArgs<DetailSportFragmentArgs>()

    private lateinit var binding: DetailSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailSportFragmentBinding.bind(view)

        binding.detailSportNaslov.setText(args.sportData.sportNaslov)
        binding.detailSportClanak.setText(args.sportData.sportClanak)
    }

}