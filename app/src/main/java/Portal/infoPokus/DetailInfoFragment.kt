package Portal.infoPokus

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_info_fragment.view.*

class DetailInfoFragment: Fragment() {

    private val args by navArgs<DetailInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_info_fragment,container,false)

        view.detailInfoIme.text = args.detailInfoArgs.ime
        view.detailInfoPrezime.text = args.detailInfoArgs.prezime

        return view
    }

}