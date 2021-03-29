package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.retrofit.repository.Repository
import Portal.retrofit.viewModel.MainViewModel
import Portal.retrofit.viewModel.MainViewModelFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_fragment, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            Log.d("Response", response.userId.toString())
            Log.d("Response", response.id.toString())
            Log.d("Response", response.title)
            Log.d("Response", response.body)
        })

        return view
    }
}


