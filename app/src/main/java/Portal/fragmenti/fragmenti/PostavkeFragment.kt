package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.PostavkeFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class PostavkeFragment: Fragment(R.layout.postavke_fragment) {

    private lateinit var binding: PostavkeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PostavkeFragmentBinding.bind(view)
    }

}