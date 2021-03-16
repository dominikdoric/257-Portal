package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.ZabavaTable
import Portal.viewModel.ZabavaViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.view.*
import java.sql.Time
import java.sql.Timestamp
import java.text.DateFormat
import java.text.DateFormat.getTimeInstance
import java.text.SimpleDateFormat
import java.util.*

class DodajNovoZabava : Fragment() {

    private lateinit var mZabavaViewModel: ZabavaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_zabava_fragment, container, false)

        mZabavaViewModel = ViewModelProvider(this).get(ZabavaViewModel::class.java)

        view.gumbSpremiZabavu.setOnClickListener {
            val action = DodajNovoZabavaDirections.actionMenuDodajNovuZabavaToZabavaNavDrawer()
            findNavController().navigate(action)
            Toast.makeText(requireContext(),
                "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                Toast.LENGTH_LONG)
                .show()
            insertDataToDatabase()
        }
        return view
    }

    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = et_zabava_naslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = et_zabava_clanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val zabava = ZabavaTable(0,noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mZabavaViewModel.addZabava(zabava)
    }
}