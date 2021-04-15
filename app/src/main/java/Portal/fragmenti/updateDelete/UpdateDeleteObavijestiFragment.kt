package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeleteObavijestiFragmentBinding
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
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteObavijestiFragment : Fragment(R.layout.update_delete_obavijesti_fragment) {

    private val args by navArgs<UpdateDeleteObavijestiFragmentArgs>()
    private val mObavijestiViewModel: ObavijestiViewModel by viewModels()
    private lateinit var binding: UpdateDeleteObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeleteObavijestiFragmentBinding.bind(view)

        binding.updateObavijestiNaslov.setText(args.currentObavijest.obavijestiNaslov)
        binding.updateObavijestiClanak.setText(args.currentObavijest.obavijestiClanak)

        binding.gumbUpdateObavijesti.setOnClickListener {
            updateItemObavijesti()
        }

        binding.gumbDeleteObavijesti.setOnClickListener {
            deleteItemObavijesti()
        }

    }

    private fun deleteItemObavijesti() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mObavijestiViewModel.deleteObavijesti(args.currentObavijest)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteObavijestiFragment2_to_obavijestiNavDrawer)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati ${args.currentObavijest.obavijestiNaslov}?")
        builder.setMessage("Jeste li sigurni da želite obrisati?")
        builder.create().show()
    }

    private fun updateItemObavijesti() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovObavijesti = binding.updateObavijestiNaslov.text.toString()
        val clanakObavijesti = binding.updateObavijestiClanak.text.toString()
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