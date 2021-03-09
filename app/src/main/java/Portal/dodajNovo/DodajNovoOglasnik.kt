package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.OglasnikTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.OglasnikViewModel
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dodaj_novo_oglasnik_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_oglasnik_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov

class DodajNovoOglasnik: Fragment() {

    private lateinit var mOglasnikViewModel: OglasnikViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_oglasnik_fragment,container,false)

        mOglasnikViewModel = ViewModelProvider(this).get(OglasnikViewModel::class.java)

        view.gumbSpremiOglasnik.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val noviNaslov = et_oglasnik_naslov.text.toString()
        val novoVrijeme = et_oglasnik_vrijeme.text.toString()
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val oglasnik = OglasnikTable(noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mOglasnikViewModel.addOglasnik(oglasnik)
    }

}