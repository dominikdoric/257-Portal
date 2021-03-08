package Portal.fragmenti

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.sport_fragment.*
import kotlinx.android.synthetic.main.zabava_fragment.*

class SportFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.sport_fragment,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewSport.addItemDecoration(DividerItemDecoration
            (recyclerViewSport.context,DividerItemDecoration.VERTICAL))
    }

}