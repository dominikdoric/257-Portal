package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.adapter.SportAdapter
import Portal.viewModel.SportViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.sport_fragment.*
import kotlinx.android.synthetic.main.sport_fragment.view.*

@AndroidEntryPoint
class SportFragment : Fragment() {

    private val sportViewModel: SportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.sport_fragment, container, false)

        //RecyclerView
        val adapter = SportAdapter()
        val recyclerSport = view.recyclerViewSport
        recyclerSport.adapter = adapter
        recyclerSport.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        sportViewModel.readAllDataSport.observe(viewLifecycleOwner, Observer { sport ->
            adapter.setData(sport)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewSport.addItemDecoration(
            DividerItemDecoration
                (recyclerViewSport.context, DividerItemDecoration.VERTICAL)
        )
    }
}