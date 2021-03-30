package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailOglasnikFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailOglasnikFragment : Fragment(R.layout.detail_oglasnik_fragment) {

    private val args by navArgs<DetailOglasnikFragmentArgs>()
    private lateinit var binding: DetailOglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailOglasnikFragmentBinding.bind(view)

        binding.detailOglasnikNaslov.text = args.oglasnikData.oglasnikNaslov
        binding.detailOglasnikCijena.text = args.oglasnikData.oglasnikCijena
        binding.detailOglasnikLokacija.text = args.oglasnikData.oglasnikLokacija
        binding.detailOglasnikBroj.text = args.oglasnikData.oglasnikBroj
        binding.detailOglasnikClanak.text = args.oglasnikData.oglasnikClanak

    }

}