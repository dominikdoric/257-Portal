package Portal.infoPokus

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.info_fragment.*

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val infoViewModel: InfoViewModel by viewModels()
    private lateinit var infoAdapter: InfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_fragment, container, false)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() = recyclerViewInfo.apply {
        infoAdapter = InfoAdapter()
        adapter = infoAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

}


