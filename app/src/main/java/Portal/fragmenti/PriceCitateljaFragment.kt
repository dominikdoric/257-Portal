package Portal.fragmenti

import Portal.a257.R
import Portal.adapter.PriceCitateljaAdapter
import Portal.viewModel.PriceCitateljaViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.price_citatelja_fragment.*
import kotlinx.android.synthetic.main.price_citatelja_fragment.view.*

@AndroidEntryPoint
class PriceCitateljaFragment: Fragment() {

    private val mPriceCitateljaViewModel: PriceCitateljaViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.price_citatelja_fragment,container,false)

        //RecyclerView
        val adapter = PriceCitateljaAdapter()
        val recyclerPriceCitatelja = view.recyclerViewPriceCitatelja
        recyclerPriceCitatelja.adapter = adapter
        recyclerPriceCitatelja.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        mPriceCitateljaViewModel.readAllDataPriceCitatelja.observe(viewLifecycleOwner, Observer { priceCitatelja ->
            adapter.setData(priceCitatelja)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPriceCitatelja.addItemDecoration(
            DividerItemDecoration(recyclerViewPriceCitatelja.context,DividerItemDecoration.VERTICAL)
        )
    }

}