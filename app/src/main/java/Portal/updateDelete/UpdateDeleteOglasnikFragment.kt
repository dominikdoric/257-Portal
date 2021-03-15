package Portal.updateDelete

import Portal.a257.R
import Portal.database.table.OglasnikTable
import Portal.viewModel.OglasnikViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_oglasnik_fragment.*
import kotlinx.android.synthetic.main.update_delete_oglasnik_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateDeleteOglasnikFragment: Fragment() {

    private val args by navArgs<UpdateDeleteOglasnikFragmentArgs>()
    private lateinit var mOglasnikViewModel: OglasnikViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_oglasnik_fragment,container,false)

        mOglasnikViewModel = ViewModelProvider(this).get(OglasnikViewModel::class.java)

        view.updateOglasnikNaslov.setText(args.currentOglasnik.oglasnikNaslov)
        view.updateOglasnikClanak.setText(args.currentOglasnik.oglasnikClanak)
        view.updateOglasnikCijena.setText(args.currentOglasnik.oglasnikCijena)
        view.updateOglasnikLokacija.setText(args.currentOglasnik.oglasnikLokacija)
        view.updateOglasnikBroj.setText(args.currentOglasnik.oglasnikBroj)

        view.gumbUpdateOglasnik.setOnClickListener {
            updateItemOglasnik()
        }

        return view
    }

    private fun updateItemOglasnik() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovOglasnik = updateOglasnikNaslov.text.toString()
        val clanakOglasnik = updateOglasnikClanak.text.toString()
        val cijenaOglasnik = updateOglasnikCijena.text.toString()
        val lokacijaOglasnik = updateOglasnikLokacija.text.toString()
        val brojOglasnik = updateOglasnikBroj.text.toString()
        val vrijemeOglasnik = currentDate
        val slikaOglasnik = 0

        val updateOglasnik = OglasnikTable(args.currentOglasnik.id,slikaOglasnik,clanakOglasnik,naslovOglasnik,cijenaOglasnik,lokacijaOglasnik,brojOglasnik,vrijemeOglasnik)
        mOglasnikViewModel.updateOglasnik(updateOglasnik)
        findNavController().navigate(R.id.action_updateDeleteOglasnikFragment_to_oglasnikNavDrawer)

    }

}