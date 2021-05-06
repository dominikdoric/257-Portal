package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailVijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class VijestiDetail: Fragment(R.layout.detail_vijesti) {

    private lateinit var binding: DetailVijestiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailVijestiBinding.bind(view)
    }

}