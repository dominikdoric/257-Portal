package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import Portal.a257.databinding.DetailObavijestiFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_obavijesti_fragment.view.*

class DetailObavijestiFragment : Fragment(R.layout.detail_obavijesti_fragment) {

    private val args by navArgs<DetailObavijestiFragmentArgs>()

    private lateinit var binding: DetailObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailObavijestiFragmentBinding.bind(view)

        binding.detailObavijestiNaslov.setText(args.obavijestiData.obavijestiNaslov)
        binding.detailObavijestiClanak.setText(args.obavijestiData.obavijestiClanak)
    }

}