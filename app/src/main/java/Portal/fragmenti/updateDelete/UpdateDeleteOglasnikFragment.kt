package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.database.table.OglasnikTable
import Portal.viewModel.OglasnikViewModel
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
import kotlinx.android.synthetic.main.update_delete_oglasnik_fragment.*
import kotlinx.android.synthetic.main.update_delete_oglasnik_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateDeleteOglasnikFragment : Fragment() {

    private val args by navArgs<UpdateDeleteOglasnikFragmentArgs>()
    private val mOglasnikViewModel: OglasnikViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_oglasnik_fragment, container, false)

        view.updateOglasnikNaslov.setText(args.currentOglasnik.oglasnikNaslov)
        view.updateOglasnikClanak.setText(args.currentOglasnik.oglasnikClanak)
        view.updateOglasnikCijena.setText(args.currentOglasnik.oglasnikCijena)
        view.updateOglasnikLokacija.setText(args.currentOglasnik.oglasnikLokacija)
        view.updateOglasnikBroj.setText(args.currentOglasnik.oglasnikBroj)

        view.gumbUpdateOglasnik.setOnClickListener {
            updateItemOglasnik()
        }

        view.gumbDeleteOglasnik.setOnClickListener {
            deleteItemOglasnik()
        }

        return view
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

        val naslovOglasnik = updateOglasnikNaslov.text.toString()
        val clanakOglasnik = updateOglasnikClanak.text.toString()
        val cijenaOglasnik = updateOglasnikCijena.text.toString()
        val lokacijaOglasnik = updateOglasnikLokacija.text.toString()
        val brojOglasnik = updateOglasnikBroj.text.toString()
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