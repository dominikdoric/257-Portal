package Portal.updateDelete

import Portal.a257.R
import Portal.database.table.PriceCitateljaTable
import Portal.database.table.SportTable
import Portal.viewModel.PriceCitateljaViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_price_citatelja_fragment.*
import kotlinx.android.synthetic.main.update_delete_price_citatelja_fragment.view.*
import kotlinx.android.synthetic.main.update_delete_sport_fragment.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateDeletePriceCitateljaFragment: Fragment() {

    private val args by navArgs<UpdateDeletePriceCitateljaFragmentArgs>()
    private lateinit var mPriceCitateljaViewModel: PriceCitateljaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_price_citatelja_fragment,container,false)

        mPriceCitateljaViewModel = ViewModelProvider(this).get(PriceCitateljaViewModel::class.java)

        view.updatePriceCitateljaNaslov.setText(args.currentPriceCitatelja.priceCitateljaNaslov)
        view.updatePriceCitateljaClanak.setText(args.currentPriceCitatelja.priceCitateljaClanak)

        view.gumbUpdatePriceCitatelja.setOnClickListener {
            updateItemPriceCitatelja()
        }

        view.gumbDeletePriceCitatelja.setOnClickListener {
            deleteItemPriceCitatelja()
        }

        return view
    }

    private fun deleteItemPriceCitatelja() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mPriceCitateljaViewModel.deletePriceCitatelja(args.currentPriceCitatelja)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateDeletePriceCitateljaFragment_to_priceCitateljaNavDrawer)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ${args.currentPriceCitatelja.priceCitateljaNaslov}?")
        builder.setMessage("Are you sure you want to delete ${args.currentPriceCitatelja.priceCitateljaNaslov}?")
        builder.create().show()
    }

    private fun updateItemPriceCitatelja() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovPriceCitatelja = updatePriceCitateljaNaslov.text.toString()
        val clanakPriceCitatelja = updatePriceCitateljaClanak.text.toString()
        val vrijemePriceCitatelja = currentDate
        val slikaPriceCitatelja = 0

        val updatePriceCitatelja = PriceCitateljaTable(args.currentPriceCitatelja.id,naslovPriceCitatelja,clanakPriceCitatelja,vrijemePriceCitatelja,slikaPriceCitatelja)
        mPriceCitateljaViewModel.updatePriceCitatelja(updatePriceCitatelja)
        findNavController().navigate(R.id.action_updateDeletePriceCitateljaFragment_to_priceCitateljaNavDrawer)
    }

}