package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.updateDelete.UpdateDeleteSportFragmentArgs
import Portal.viewModel.SportViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.update_delete_sport_fragment.*
import kotlinx.android.synthetic.main.update_delete_sport_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteSportFragment : Fragment() {

    private val args by navArgs<UpdateDeleteSportFragmentArgs>()
    private val mSportViewModel: SportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container:  ViewGroup? ,
        savedInstanceState:  Bundle?
    ): View? {
        val view  =  inflater.inflate(R.layout.update_delete_sport_fragment, container, false)

        view.updateSportNaslov.setText(args.currentSport.sportNaslov)
        view.updateSportClanak.setText(args.currentSport.sportClanak)

        view.gumbUpdateSport.setOnClickListener {
            updateItemSport()
        }

        view.gumbDeleteSport.setOnClickListener {
            deleteItemSport()
        }

        return view
    }

    private fun deleteItemSport() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mSportViewModel.deleteSport(args.currentSport)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentSport.sportNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentSport.sportNaslov}?")
        builder.create().show()
    }

    private fun updateItemSport() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovSport = updateSportNaslov.text.toString()
        val clanakSport = updateSportClanak.text.toString()
        val vrijemeSport = currentDate
        val slikaSport = 0

        val updateSport =
            SportTable(args.currentSport.id, naslovSport, clanakSport, vrijemeSport, slikaSport)
        mSportViewModel.updateSport(updateSport)
        findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
    }

}