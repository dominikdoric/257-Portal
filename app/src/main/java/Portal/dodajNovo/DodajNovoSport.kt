package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.SportViewModel
import Portal.viewModel.VijestiViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DodajNovoSport: Fragment() {

    private lateinit var mSportViewModel: SportViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_sport_fragment,container,false)

        mSportViewModel = ViewModelProvider(this).get(SportViewModel::class.java)

        view.gumbSpremiSport.setOnClickListener {
            val action = DodajNovoSportDirections.actionMenuDodajNoviSportToSportNavDrawer()
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

        val noviNaslov = et_sport_naslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val sport = SportTable(noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mSportViewModel.addSport(sport)
    }

}