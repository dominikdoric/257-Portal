package Portal.fragmenti

import Portal.MainViewModel
import Portal.MainViewModelFactory
import Portal.a257.R
import Portal.adapter.MyAdapter
import Portal.repository.Repository
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.android.synthetic.main.info_fragment.view.*

class InfoFragment: Fragment() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.info_fragment,container,false)

        //setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPosts(2,"id","desc")
        viewModel.myCustomPosts.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let{myAdapter.setData(it)}
            }else{
                Toast.makeText(requireContext(),response.code(),Toast.LENGTH_LONG).show()
            }
        })

        view.recyclerView.adapter = myAdapter
        view.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun setupRecyclerView(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}