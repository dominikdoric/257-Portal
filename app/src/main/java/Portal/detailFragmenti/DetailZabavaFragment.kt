package Portal.detailFragmenti

import Portal.a257.R
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_zabava_fragment.view.*

class DetailZabavaFragment: Fragment() {

    private val args by navArgs<DetailZabavaFragmentArgs>()
    private lateinit var mZabavaViewModel: ZabavaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_zabava_fragment,container,false)

        mZabavaViewModel = ViewModelProvider(this).get(ZabavaViewModel::class.java)

        view.detailZabavaNaslov.setText(args.zabavaData.zabavaNaslov)
        view.detailZabavaClanak.setText(args.zabavaData.zabavaClanak)

        return view
    }

}