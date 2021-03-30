package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailZabavaFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailZabavaFragment : Fragment(R.layout.detail_zabava_fragment) {

    private val args by navArgs<DetailZabavaFragmentArgs>()

    private lateinit var binding: DetailZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailZabavaFragmentBinding.bind(view)

        binding.detailZabavaNaslov.setText(args.zabavaData.zabavaNaslov)
        binding.detailZabavaClanak.setText(args.zabavaData.zabavaClanak)
    }

}