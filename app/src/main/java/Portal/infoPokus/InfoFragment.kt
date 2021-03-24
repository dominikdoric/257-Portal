package Portal.infoPokus

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.android.synthetic.main.info_fragment.view.*

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val infoViewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_fragment, container, false)

        //RecyclerView
        val adapter = InfoAdapter()
        val recyclerInfo = view.recyclerViewInfo
        recyclerInfo.adapter = adapter
        recyclerInfo.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        infoViewModel.readAllDataInfo.observe(viewLifecycleOwner, Observer { info ->
            adapter.setData(info)
        })

        return view
    }
}


