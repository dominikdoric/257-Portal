package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailObavijestiBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ObavijestiDetail: Fragment(R.layout.detail_obavijesti) {

    private lateinit var binding: DetailObavijestiBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailObavijestiBinding.bind(view)
    }

}