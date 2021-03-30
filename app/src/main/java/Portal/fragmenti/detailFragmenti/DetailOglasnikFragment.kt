package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailOglasnikFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_oglasnik_fragment.view.*

class DetailOglasnikFragment : Fragment(R.layout.detail_oglasnik_fragment) {

    private val args by navArgs<DetailOglasnikFragmentArgs>()

    private lateinit var binding: DetailOglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailOglasnikFragmentBinding.bind(view)

        binding.detailOglasnikNaslov.setText(args.oglasnikData.oglasnikNaslov)
        binding.detailOglasnikCijena.setText(args.oglasnikData.oglasnikCijena)
        binding.detailOglasnikLokacija.setText(args.oglasnikData.oglasnikLokacija)
        binding.detailOglasnikBroj.setText(args.oglasnikData.oglasnikBroj)
        binding.detailOglasnikClanak.setText(args.oglasnikData.oglasnikClanak)

    }

}