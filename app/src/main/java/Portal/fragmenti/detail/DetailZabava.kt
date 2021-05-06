package Portal.fragmenti.detail

import Portal.a257.R
import Portal.a257.databinding.DetailZabavaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class DetailZabava: Fragment(R.layout.detail_zabava) {

    private lateinit var binding: DetailZabavaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailZabavaBinding.bind(view)



    }

}