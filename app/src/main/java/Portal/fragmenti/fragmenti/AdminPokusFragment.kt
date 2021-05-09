package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.AdminPokusFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class AdminPokusFragment: Fragment(R.layout.admin_pokus_fragment) {

    private lateinit var binding: AdminPokusFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPokusFragmentBinding.bind(view)

    }
}