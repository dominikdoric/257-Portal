package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteOglasnikFragmentBinding
import Portal.database.table.OglasnikTable
import Portal.viewModel.OglasnikViewModel
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
class UpdateDeleteOglasnikFragment : Fragment(R.layout.update_delete_oglasnik_fragment) {

    private val args by navArgs<UpdateDeleteOglasnikFragmentArgs>()
    private val mOglasnikViewModel: OglasnikViewModel by viewModels()
    private lateinit var binding: UpdateDeleteOglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteOglasnikFragmentBinding.bind(view)

        binding.updateOglasnikNaslov.setText(args.currentOglasnik.oglasnikNaslov)
        binding.updateOglasnikClanak.setText(args.currentOglasnik.oglasnikClanak)
        binding.updateOglasnikCijena.setText(args.currentOglasnik.oglasnikCijena)
        binding.updateOglasnikLokacija.setText(args.currentOglasnik.oglasnikLokacija)
        binding.updateOglasnikBroj.setText(args.currentOglasnik.oglasnikBroj)

        binding.gumbUpdateOglasnik.setOnClickListener {
            updateItemOglasnik()
        }

        binding.gumbDeleteOglasnik.setOnClickListener {
            deleteItemOglasnik()
        }
    }

    private fun deleteItemOglasnik() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mOglasnikViewModel.deleteOglasnik(args.currentOglasnik)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteOglasnikFragment_to_oglasnikNavDrawer)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentOglasnik.oglasnikNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentOglasnik.oglasnikNaslov}?")
        builder.create().show()
    }

    private fun updateItemOglasnik() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovOglasnik = binding.updateOglasnikNaslov.text.toString()
        val clanakOglasnik = binding.updateOglasnikClanak.text.toString()
        val cijenaOglasnik = binding.updateOglasnikCijena.text.toString()
        val lokacijaOglasnik = binding.updateOglasnikLokacija.text.toString()
        val brojOglasnik = binding.updateOglasnikBroj.text.toString()
        val vrijemeOglasnik = currentDate
        val slikaOglasnik = 0

        val updateOglasnik = OglasnikTable(
            args.currentOglasnik.id,
            slikaOglasnik,
            clanakOglasnik,
            naslovOglasnik,
            cijenaOglasnik,
            lokacijaOglasnik,
            brojOglasnik,
            vrijemeOglasnik
        )
        mOglasnikViewModel.updateOglasnik(updateOglasnik)
        findNavController().navigate(R.id.action_updateDeleteOglasnikFragment_to_oglasnikNavDrawer)

    }
}