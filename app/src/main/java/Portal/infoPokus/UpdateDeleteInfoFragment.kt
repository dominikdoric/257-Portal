package Portal.infoPokus

import Portal.a257.R
import Portal.database.table.InfoTable
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
import kotlinx.android.synthetic.main.update_delete_info_fragment.*
import kotlinx.android.synthetic.main.update_delete_info_fragment.view.*

@AndroidEntryPoint
class UpdateDeleteInfoFragment: Fragment() {

    private val args by navArgs<UpdateDeleteInfoFragmentArgs>()
    private val infoViewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_info_fragment,container,false)

        view.updateInfoIme.setText(args.updateInfoArgs.ime)
        view.updateInfoPrezime.setText(args.updateInfoArgs.prezime)

        view.gumbUpdateInfo.setOnClickListener {
            updateItemInfo()
        }

        view.gumbDeleteInfo.setOnClickListener {
            deleteItemInfo()
        }

        return view
    }

    private fun deleteItemInfo() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            infoViewModel.deleteInfo(args.updateInfoArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeleteInfoFragment_to_infoBottomNav)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    private fun updateItemInfo() {
        val imeInfo = updateInfoIme.text.toString()
        val prezimeInfo = updateInfoPrezime.text.toString()

        val updateInfo = InfoTable(args.updateInfoArgs.id,imeInfo,prezimeInfo)
        infoViewModel.updateInfo(updateInfo)
        findNavController().navigate(R.id.action_updateDeleteInfoFragment_to_infoBottomNav)
    }

}