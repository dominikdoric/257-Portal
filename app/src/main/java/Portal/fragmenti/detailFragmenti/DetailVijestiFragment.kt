package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailVijestiFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class DetailVijestiFragment : Fragment(R.layout.detail_vijesti_fragment) {

    private val args by navArgs<DetailVijestiFragmentArgs>()
    private lateinit var binding: DetailVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailVijestiFragmentBinding.bind(view)

        binding.detailVijestiNaslov.text = args.vijestiData.vijestiNaslov
        binding.detailVijestiClanak.text = args.vijestiData.vijestiClanak
        val image = binding.detailVijestiImage

        Glide.with(requireContext())
            .load(R.drawable.jaksic)
            .into(image)
    }

}