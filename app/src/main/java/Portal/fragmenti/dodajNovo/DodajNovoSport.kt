package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.dodajNovo.DodajNovoSportDirections
import Portal.viewModel.SportViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoSport : Fragment() {

    private val mSportViewModel: SportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_sport_fragment, container, false)

        view.gumbSpremiSport.setOnClickListener {
            val action = DodajNovoSportDirections.actionMenuDodajNoviSportToSportNavDrawer()
            findNavController().navigate(action)
            Toast.makeText(
                requireContext(),
                "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                Toast.LENGTH_LONG
            )
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
        val noviClanak = et_sport_clanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val sport = SportTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mSportViewModel.addSport(sport)
    }

}