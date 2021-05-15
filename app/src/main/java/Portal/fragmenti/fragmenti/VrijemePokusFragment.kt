package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.VrijemePokusFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class VrijemePokusFragment: Fragment(R.layout.vrijeme_pokus_fragment) {

    private lateinit var binding: VrijemePokusFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = VrijemePokusFragmentBinding.bind(view)
    }
}