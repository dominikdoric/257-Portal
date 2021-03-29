package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import Portal.viewModel.ObavijestiViewModel
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
import kotlinx.android.synthetic.main.update_delete_obavijesti_fragment.*
import kotlinx.android.synthetic.main.update_delete_obavijesti_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteObavijestiFragment : Fragment() {

    private val args by navArgs<UpdateDeleteObavijestiFragmentArgs>()
    private val mObavijestiViewModel: ObavijestiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_obavijesti_fragment, container, false)

        view.updateObavijestiNaslov.setText(args.currentObavijest.obavijestiNaslov)
        view.updateObavijestiClanak.setText(args.currentObavijest.obavijestiClanak)

        view.gumbUpdateObavijesti.setOnClickListener {
            updateItemObavijesti()
        }

        view.gumbDeleteObavijesti.setOnClickListener {
            deleteItemObavijesti()
        }

        return view
    }

    private fun deleteItemObavijesti() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mObavijestiViewModel.deleteObavijesti(args.currentObavijest)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteObavijestiFragment2_to_obavijestiNavDrawer)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentObavijest.obavijestiNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentObavijest.obavijestiNaslov}?")
        builder.create().show()
    }

    private fun updateItemObavijesti() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovObavijesti = updateObavijestiNaslov.text.toString()
        val clanakObavijesti = updateObavijestiClanak.text.toString()
        val slikaObavijesti = 0
        val vrijemeObavijesti = currentDate

        val updateObavijesti = ObavijestiTable(
            args.currentObavijest.id,
            naslovObavijesti,
            clanakObavijesti,
            vrijemeObavijesti,
            slikaObavijesti
        )

        mObavijestiViewModel.updateObavijesti(updateObavijesti)
        findNavController().navigate(R.id.action_updateDeleteObavijestiFragment2_to_obavijestiNavDrawer)

    }
}