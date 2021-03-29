package Portal.fragmenti.detailFragmenti

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_oglasnik_fragment.view.*

class DetailOglasnikFragment : Fragment() {

    private val args by navArgs<DetailOglasnikFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_oglasnik_fragment, container, false)

        view.detailOglasnikNaslov.setText(args.oglasnikData.oglasnikNaslov)
        view.detailOglasnikCijena.setText(args.oglasnikData.oglasnikCijena)
        view.detailOglasnikLokacija.setText(args.oglasnikData.oglasnikLokacija)
        view.detailOglasnikBroj.setText(args.oglasnikData.oglasnikBroj)
        view.detailOglasnikClanak.setText(args.oglasnikData.oglasnikClanak)

        return view
    }

}