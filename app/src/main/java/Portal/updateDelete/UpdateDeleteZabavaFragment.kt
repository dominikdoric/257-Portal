package Portal.updateDelete

import Portal.a257.R
import Portal.database.table.ZabavaTable
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.update_delete_zabava_fragment.*
import kotlinx.android.synthetic.main.update_delete_zabava_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateDeleteZabavaFragment: Fragment() {

    private val args by navArgs<UpdateDeleteZabavaFragmentArgs>()
    private lateinit var mZabavaViewModel: ZabavaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_delete_zabava_fragment,container,false)

        mZabavaViewModel = ViewModelProvider(this).get(ZabavaViewModel::class.java)

        view.updateZabavaNaslov.setText(args.currentZabava.zabavaNaslov)
        view.updateZabavaClanak.setText(args.currentZabava.zabavaClanak)

        view.gumbUpdateZabava.setOnClickListener {
            updateItemZabava()
        }

        return view
    }

    private fun updateItemZabava() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovZabava = updateZabavaNaslov.text.toString()
        val clanakZabava = updateZabavaClanak.text.toString()
        val vrijemeZabava = currentDate
        val slikaZabava = 0

        val updateZabava = ZabavaTable(args.currentZabava.id,naslovZabava,clanakZabava,vrijemeZabava,slikaZabava)
        mZabavaViewModel.updateZabava(updateZabava)
        findNavController().navigate(R.id.action_updateDeleteZabavaFragment_to_zabavaNavDrawer)
    }

}