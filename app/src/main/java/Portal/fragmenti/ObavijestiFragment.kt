package Portal.fragmenti

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.obavijesti_fragment.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class ObavijestiFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.obavijesti_fragment,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewObavijesti.addItemDecoration(DividerItemDecoration
            (recyclerViewObavijesti.context,DividerItemDecoration.VERTICAL))
    }

}