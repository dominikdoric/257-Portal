package Portal.fragmenti.updateDelete

import Portal.a257.databinding.UpdateDeleteOglasnikBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class UpdateDeleteOglasnik: Fragment() {

    private lateinit var binding: UpdateDeleteOglasnikBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteOglasnikBinding.bind(view)

    }

}