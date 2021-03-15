package Portal.fragmenti

import Portal.a257.R
import Portal.adapter.SportAdapter
import Portal.dodajNovo.DodajNovoSportDirections
import Portal.viewModel.SportViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.*
import kotlinx.android.synthetic.main.sport_fragment.*
import kotlinx.android.synthetic.main.sport_fragment.view.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class SportFragment : Fragment() {

    private lateinit var mSportViewModel: SportViewModel

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
        mSportViewModel = ViewModelProvider(this).get(SportViewModel::class.java)
        mSportViewModel.readAllDataSport.observe(viewLifecycleOwner, Observer { sport ->
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

        /*
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout_host, sportDetailFragment)
            ?.addToBackStack(null)
            ?.commit()*/
        //childFragmentManager.beginTransaction().apply {
        //  replace(R.id.frameLayout_host, zabavaDetailFragment)
        //commit()
}