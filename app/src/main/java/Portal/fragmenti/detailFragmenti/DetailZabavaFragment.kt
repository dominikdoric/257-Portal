package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailZabavaFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class DetailZabavaFragment : Fragment(R.layout.detail_zabava_fragment) {

    private val args by navArgs<DetailZabavaFragmentArgs>()
    private lateinit var binding: DetailZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailZabavaFragmentBinding.bind(view)

        binding.detailZabavaNaslov.text = args.zabavaData.zabavaNaslov
        binding.detailZabavaClanak.text = args.zabavaData.zabavaClanak
        val image = binding.detailZabavaImage

        Glide.with(requireContext())
            .load(R.drawable.jaksic)
            .into(image)
    }

}