package Portal.detailFragmenti

import Portal.a257.R
import Portal.viewModel.OglasnikViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

class DetailOglasnikFragment: Fragment() {

    private val args by navArgs<DetailOglasnikFragmentArgs>()
    private lateinit var mOglasnikViewModel: OglasnikViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_oglasnik_fragment,container,false)

        mOglasnikViewModel = ViewModelProvider(this).get(OglasnikViewModel::class.java)


        return view
    }

}