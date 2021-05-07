package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePriceCitateljaBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class UpdateDeletePriceCitatelja: Fragment(R.layout.update_delete_price_citatelja) {

    private lateinit var binding: UpdateDeletePriceCitateljaBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePriceCitateljaBinding.bind(view)

    }

}