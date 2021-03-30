package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.retrofit.model.WeatherModel
import Portal.retrofit.viewModel.MainViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.info_fragment.view.*

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val infoViewModel: MainViewModel by viewModels()
    private lateinit var someObject: WeatherModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_fragment, container, false)

        infoViewModel.getWeather()
        infoViewModel.myResponse.observe(requireContext(), Observer { response ->
            view.visibility.(someObject.visibility)
        })

        return view
    }
}


