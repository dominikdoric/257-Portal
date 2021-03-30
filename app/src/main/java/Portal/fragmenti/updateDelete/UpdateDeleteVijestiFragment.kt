package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteVijestiFragmentBinding
import Portal.database.table.VijestiTable
import Portal.viewModel.VijestiViewModel
import android.app.AlertDialog
import android.os.Bundle
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
class UpdateDeleteVijestiFragment : Fragment(R.layout.update_delete_vijesti_fragment) {

    private val args by navArgs<UpdateDeleteVijestiFragmentArgs>()
    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: UpdateDeleteVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteVijestiFragmentBinding.bind(view)

        binding.updateVijestiNaslov.setText(args.currentVijest.vijestiNaslov)
        binding.updateVijestiClanak.setText(args.currentVijest.vijestiClanak)

        binding.gumbUpdateVijesti.setOnClickListener {
            updateItemVijesti()
        }

        binding.gumbDeleteVijesti.setOnClickListener {
            deleteItemVijesti()
        }

    }

    private fun deleteItemVijesti() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mVijestiViewModel.deleteVijesti(args.currentVijest)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteVijestiFragment_to_vijestiNavDrawer)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentVijest.vijestiNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentVijest.vijestiNaslov}?")
        builder.create().show()
    }

    private fun updateItemVijesti() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovVijesti = binding.updateVijestiNaslov.text.toString()
        val clanakVijesti = binding.updateVijestiClanak.text.toString()
        val slikaVijesti = 0
        val vrijemeVijesti = currentDate

        val updateVijesti = VijestiTable(
            args.currentVijest.id,
            naslovVijesti,
            clanakVijesti,
            vrijemeVijesti,
            slikaVijesti
        )
        mVijestiViewModel.updateVijesti(updateVijesti)
        findNavController().navigate(R.id.action_updateDeleteVijestiFragment_to_vijestiNavDrawer)
    }

}