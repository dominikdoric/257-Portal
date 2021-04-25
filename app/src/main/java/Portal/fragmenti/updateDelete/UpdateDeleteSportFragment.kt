package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteSportFragmentBinding
import Portal.database.table.SportTable
import Portal.viewModel.SportViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteSportFragment : Fragment(R.layout.update_delete_sport_fragment) {

    //private val args by navArgs<UpdateDeleteSportFragmentArgs>()
    private lateinit var binding: UpdateDeleteSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteSportFragmentBinding.bind(view)

        //binding.updateSportNaslov.setText(args.currentSport.sportNaslov)
        //binding.updateSportClanak.setText(args.currentSport.sportClanak)

        binding.gumbUpdateSport.setOnClickListener {
            updateItemSport()
        }

        binding.gumbDeleteSport.setOnClickListener {
            deleteItemSport()
        }
    }

    private fun deleteItemSport() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            //mSportViewModel.deleteSport(args.currentSport)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            //findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        //builder.setTitle("Obrisati ${args.currentSport.sportNaslov}?")
        builder.setMessage("Jeste li sigurni da želite obrisati ?")
        builder.create().show()
    }

    private fun updateItemSport() {
        //val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        //val currentDate = sdf.format(Date())

        //val naslovSport = binding.updateSportNaslov.text.toString()
        //val clanakSport = binding.updateSportClanak.text.toString()
        //val vrijemeSport = currentDate
        //val slikaSport = 0

        //val updateSport =
            //SportTable(args.currentSport.id, naslovSport, clanakSport, vrijemeSport, slikaSport)
        //mSportViewModel.updateSport(updateSport)
        //findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
    }

}