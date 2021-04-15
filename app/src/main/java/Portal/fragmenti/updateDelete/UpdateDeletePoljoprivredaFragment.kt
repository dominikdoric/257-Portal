package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePoljoprivredaFragmentBinding
import Portal.database.table.PoljoprivredaTable
import Portal.viewModel.PoljoprivredaViewModel
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
class UpdateDeletePoljoprivredaFragment: Fragment(R.layout.update_delete_poljoprivreda_fragment) {

    private val args by navArgs<UpdateDeletePoljoprivredaFragmentArgs>()
    private val mPoljoprivredaViewModel: PoljoprivredaViewModel by viewModels()
    private lateinit var binding: UpdateDeletePoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePoljoprivredaFragmentBinding.bind(view)

        binding.updatePoljoprivredaNaslov.setText(args.updatePoljoprivredaArgs.poljoprivredaNaslov)
        binding.updatePoljoprivredaClanak.setText(args.updatePoljoprivredaArgs.poljoprivredaClanak)

        binding.gumbUpdatePoljoprivreda.setOnClickListener {
            updateItemPoljoprivreda()
        }

        binding.gumbDeletePoljoprivreda.setOnClickListener {
            deleteItemPoljoprivreda()
        }
    }

    private fun deleteItemPoljoprivreda() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mPoljoprivredaViewModel.deletePoljoprivreda(args.updatePoljoprivredaArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati ${args.updatePoljoprivredaArgs.poljoprivredaNaslov}?")
        builder.setMessage("Jeste li sigurni da želite obrisati ${args.updatePoljoprivredaArgs.poljoprivredaNaslov}?")
        builder.create().show()
    }

    private fun updateItemPoljoprivreda() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovSport = binding.updatePoljoprivredaNaslov.text.toString()
        val clanakSport = binding.updatePoljoprivredaClanak.text.toString()
        val vrijemeSport = currentDate
        val slikaSport = 0

        val updatePoljoprivreda =
            PoljoprivredaTable(args.updatePoljoprivredaArgs.id, naslovSport, clanakSport, vrijemeSport, slikaSport)
        mPoljoprivredaViewModel.updatePoljoprivreda(updatePoljoprivreda)
        findNavController().navigate(R.id.action_updateDeleteSportFragment_to_sportNavDrawer)
    }

}