package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.database.table.VijestiTable
import Portal.updateDelete.UpdateDeleteVijestiFragmentArgs
import Portal.viewModel.VijestiViewModel
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
import kotlinx.android.synthetic.main.update_delete_vijesti_fragment.*
import kotlinx.android.synthetic.main.update_delete_vijesti_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteVijestiFragment : Fragment() {

    private val args by navArgs<UpdateDeleteVijestiFragmentArgs>()
    private val mVijestiViewModel: VijestiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_vijesti_fragment, container, false)

        view.updateVijestiNaslov.setText(args.currentVijest.vijestiNaslov)
        view.updateVijestiClanak.setText(args.currentVijest.vijestiClanak)

        view.gumbUpdateVijesti.setOnClickListener {
            updateItemVijesti()
        }

        view.gumbDeleteVijesti.setOnClickListener {
            deleteItemVijesti()
        }

        return view
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

        val naslovVijesti = updateVijestiNaslov.text.toString()
        val clanakVijesti = updateVijestiClanak.text.toString()
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