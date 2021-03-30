package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailVijestiFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_vijesti_fragment.view.*

class DetailVijestiFragment : Fragment(R.layout.detail_vijesti_fragment) {

    private val args by navArgs<DetailVijestiFragmentArgs>()

    private lateinit var binding: DetailVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailVijestiFragmentBinding.bind(view)

        binding.detailVijestiNaslov.setText(args.vijestiData.vijestiNaslov)
        binding.detailVijestiClanak.setText(args.vijestiData.vijestiClanak)
    }

}