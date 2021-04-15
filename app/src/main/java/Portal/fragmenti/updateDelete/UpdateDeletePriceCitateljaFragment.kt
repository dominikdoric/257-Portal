package Portal.fragmenti.updateDelete

import Portal.a257.R
import Portal.a257.databinding.UpdateDeletePriceCitateljaFragmentBinding
import Portal.database.table.PriceCitateljaTable
import Portal.viewModel.PriceCitateljaViewModel
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
class UpdateDeletePriceCitateljaFragment :
    Fragment(R.layout.update_delete_price_citatelja_fragment) {

    private val args by navArgs<UpdateDeletePriceCitateljaFragmentArgs>()
    private val mPriceCitateljaViewModel: PriceCitateljaViewModel by viewModels()
    private lateinit var binding: UpdateDeletePriceCitateljaFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateDeletePriceCitateljaFragmentBinding.bind(view)

        binding.updatePriceCitateljaNaslov.setText(args.currentPriceCitatelja.priceCitateljaNaslov)
        binding.updatePriceCitateljaClanak.setText(args.currentPriceCitatelja.priceCitateljaClanak)

        binding.gumbUpdatePriceCitatelja.setOnClickListener {
            updateItemPriceCitatelja()
        }

        binding.gumbDeletePriceCitatelja.setOnClickListener {
            deleteItemPriceCitatelja()
        }
    }

    private fun deleteItemPriceCitatelja() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mPriceCitateljaViewModel.deletePriceCitatelja(args.currentPriceCitatelja)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeletePriceCitateljaFragment_to_priceCitateljaNavDrawer)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati ${args.currentPriceCitatelja.priceCitateljaNaslov}?")
        builder.setMessage("Jeste li sigurni da želite obrisati ${args.currentPriceCitatelja.priceCitateljaNaslov}?")
        builder.create().show()
    }

    private fun updateItemPriceCitatelja() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovPriceCitatelja = binding.updatePriceCitateljaNaslov.text.toString()
        val clanakPriceCitatelja = binding.updatePriceCitateljaClanak.text.toString()
        val vrijemePriceCitatelja = currentDate
        val slikaPriceCitatelja = 0

        val updatePriceCitatelja = PriceCitateljaTable(
            args.currentPriceCitatelja.id,
            naslovPriceCitatelja,
            clanakPriceCitatelja,
            vrijemePriceCitatelja,
            slikaPriceCitatelja
        )
        mPriceCitateljaViewModel.updatePriceCitatelja(updatePriceCitatelja)
        findNavController().navigate(R.id.action_updateDeletePriceCitateljaFragment_to_priceCitateljaNavDrawer)
    }

}