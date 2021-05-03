package Portal.fragmenti.fragmenti

import Portal.a257.R
import Portal.a257.databinding.ObavijestiFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ObavijestiFragment : Fragment(R.layout.obavijesti_fragment) {

    private lateinit var binding: ObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ObavijestiFragmentBinding.bind(view)


        binding.recyclerViewObavijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewObavijesti.context, DividerItemDecoration.VERTICAL)
        )


    }
}
