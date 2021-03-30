package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteZabavaFragmentBinding
import Portal.database.table.ZabavaTable
import Portal.viewModel.ZabavaViewModel
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
class UpdateDeleteZabavaFragment : Fragment() {

    private val args by navArgs<UpdateDeleteZabavaFragmentArgs>()
    private val mZabavaViewModel: ZabavaViewModel by viewModels()
    private lateinit var binding: UpdateDeleteZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteZabavaFragmentBinding.bind(view)

        binding.updateZabavaNaslov.setText(args.currentZabava.zabavaNaslov)
        binding.updateZabavaClanak.setText(args.currentZabava.zabavaClanak)

        binding.gumbUpdateZabava.setOnClickListener {
            updateItemZabava()
        }

        binding.gumbDeleteZabava.setOnClickListener {
            deleteItemZabava()
        }
    }

    private fun deleteItemZabava() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mZabavaViewModel.deleteZabava(args.currentZabava)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteZabavaFragment_to_zabavaNavDrawer)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentZabava.zabavaNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentZabava.zabavaNaslov}?")
        builder.create().show()
    }

    private fun updateItemZabava() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovZabava = binding.updateZabavaNaslov.text.toString()
        val clanakZabava = binding.updateZabavaClanak.text.toString()
        val vrijemeZabava = currentDate
        val slikaZabava = 0

        val updateZabava = ZabavaTable(
            args.currentZabava.id,
            naslovZabava,
            clanakZabava,
            vrijemeZabava,
            slikaZabava
        )
        mZabavaViewModel.updateZabava(updateZabava)
        findNavController().navigate(R.id.action_updateDeleteZabavaFragment_to_zabavaNavDrawer)
    }

}