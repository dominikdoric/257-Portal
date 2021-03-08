package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.SportViewModel
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_sport_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov

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
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val noviNaslov = et_sport_naslov.text.toString()
        val novoVrijeme = et_sport_vrijeme.text.toString()
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val sport = SportTable(0,noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mSportViewModel.addSport(sport)
    }

}