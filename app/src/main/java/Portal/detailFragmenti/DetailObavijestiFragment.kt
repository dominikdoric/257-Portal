package Portal.detailFragmenti

import Portal.a257.R
import Portal.viewModel.ObavijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_obavijesti_fragment.view.*

class DetailObavijestiFragment : Fragment() {

    private val args by navArgs<DetailObavijestiFragmentArgs>()
    private lateinit var mObavijestiViewModel: ObavijestiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_obavijesti_fragment, container, false)

        mObavijestiViewModel = ViewModelProvider(this).get(ObavijestiViewModel::class.java)

        view.detailObavijestiNaslov.setText(args.obavijestiData.obavijestiNaslov)
        view.detailObavijestiClanak.setText(args.obavijestiData.obavijestiClanak)

        return view
    }

}