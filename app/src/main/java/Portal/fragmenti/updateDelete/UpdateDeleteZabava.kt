package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteZabavaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class UpdateDeleteZabava: Fragment(R.layout.update_delete_zabava) {

    private lateinit var binding: UpdateDeleteZabavaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteZabavaBinding.bind(view)

    }

}