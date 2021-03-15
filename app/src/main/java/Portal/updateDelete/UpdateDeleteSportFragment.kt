package Portal.updateDelete

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.viewModel.SportViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_sport_fragment.*
import kotlinx.android.synthetic.main.update_delete_sport_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateDeleteSportFragment: Fragment() {

    private val args by navArgs<UpdateDeleteSportFragmentArgs>()
    private lateinit var mSportViewModel: SportViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_sport_fragment,container,false)

        mSportViewModel = ViewModelProvider(this).get(SportViewModel::class.java)

        view.updateSportNaslov.setText(args.currentSport.sportNaslov)
        view.updateSportClanak.setText(args.currentSport.sportClanak)

        view.gumbUpdateSport.setOnClickListener {
            updateItemSport()
        }

        return view
    }

    private fun updateItemSport() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovSport = updateSportNaslov.text.toString()
        val clanakSport = updateSportClanak.text.toString()
        val vrijemeSport = currentDate
        val slikaSport = 0

        val updateSport = SportTable(args.currentSport.id,naslovSport,clanakSport,vrijemeSport,slikaSport)
        mSportViewModel.updateSport(updateSport)
        findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
    }

}