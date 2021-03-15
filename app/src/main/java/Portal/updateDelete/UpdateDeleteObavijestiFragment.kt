package Portal.updateDelete

import Portal.a257.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_obavijesti_fragment.view.*

class UpdateDeleteObavijestiFragment: Fragment() {

    private val args by navArgs<UpdateDeleteObavijestiFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_obavijesti_fragment,container,false)

        view.updateObavijestiNaslov.setText(args.currentObavijest.obavijestiNaslov)
        view.updateObavijestiClanak.setText(args.currentObavijest.obavijestiClanak)

        return view
    }

}