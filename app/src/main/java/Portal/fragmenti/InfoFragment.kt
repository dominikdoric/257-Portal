package Portal.fragmenti

import Portal.MainViewModel
import Portal.MainViewModelFactory
import Portal.a257.R
import Portal.repository.Repository
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.info_fragment.*

class InfoFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.info_fragment,container,false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse2.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                Log.d("Response",response.body()?.userId.toString())
                Log.d("Response",response.body()?.id.toString())
                textView.text = response.body()?.title!!
                Log.d("Response",response.body()?.body!!)
            }else{
                Log.d("Response",response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })
        return view
    }
}