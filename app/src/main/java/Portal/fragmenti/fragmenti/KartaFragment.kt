package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.KartaFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class KartaFragment: Fragment(R.layout.karta_fragment) {

    private lateinit var binding: KartaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = KartaFragmentBinding.bind(view)
    }

}