package Portal.updateDelete

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import Portal.viewModel.ObavijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_obavijesti_fragment.*
import kotlinx.android.synthetic.main.update_delete_obavijesti_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateDeleteObavijestiFragment: Fragment() {

    private val args by navArgs<UpdateDeleteObavijestiFragmentArgs>()
    private lateinit var mObavijestiViewModel: ObavijestiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_obavijesti_fragment,container,false)

        mObavijestiViewModel = ViewModelProvider(this).get(ObavijestiViewModel::class.java)

        view.updateObavijestiNaslov.setText(args.currentObavijest.obavijestiNaslov)
        view.updateObavijestiClanak.setText(args.currentObavijest.obavijestiClanak)

        view.gumbUpdateObavijesti.setOnClickListener {
            updateItemObavijesti()
        }

        return view
    }

    private fun updateItemObavijesti(){

        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovObavijesti = updateObavijestiNaslov.text.toString()
        val clanakObavijesti = updateObavijestiClanak.text.toString()
        val slikaObavijesti = 0
        val vrijemeObavijesti = currentDate

        val updateObavijesti = ObavijestiTable(args.currentObavijest.id,naslovObavijesti,clanakObavijesti,vrijemeObavijesti,slikaObavijesti)

        mObavijestiViewModel.updateObavijesti(updateObavijesti)
        findNavController().navigate(R.id.action_updateDeleteObavijestiFragment2_to_obavijestiNavDrawer)

    }
}