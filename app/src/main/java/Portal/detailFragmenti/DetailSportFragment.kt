package Portal.detailFragmenti

import Portal.a257.R
import Portal.viewModel.SportViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_sport_fragment.view.*

class DetailSportFragment: Fragment() {

    private val args by navArgs<DetailSportFragmentArgs>()
    private lateinit var mSportViewModel: SportViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_sport_fragment,container,false)

        mSportViewModel = ViewModelProvider(this).get(SportViewModel::class.java)

        view.detailSportNaslov.setText(args.sportData.sportNaslov)
        view.detailSportClanak.setText(args.sportData.sportClanak)

        return view
    }

}