package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.VijestiTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov

class DodajNovoVijesti: Fragment() {

    private lateinit var mVijestiViewModel: VijestiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_vijesti_fragment,container,false)

        mVijestiViewModel = ViewModelProvider(this).get(VijestiViewModel::class.java)

        view.gumbSpremiVijest.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val noviNaslov = et_vijesti_naslov.text.toString()
        val novoVrijeme = et_vijesti_vrijeme.text.toString()
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val vijesti = VijestiTable(0,noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mVijestiViewModel.addVijesti(vijesti)
    }

}