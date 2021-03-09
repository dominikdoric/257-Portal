package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.ObavijestiViewModel
import Portal.viewModel.VijestiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dodaj_novo_obavijesti_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_obavijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov

class DodajNovoObavijesti: Fragment() {

    private lateinit var mObavijestViewModel: ObavijestiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_obavijesti_fragment,container,false)

        mObavijestViewModel = ViewModelProvider(this).get(ObavijestiViewModel::class.java)

        view.gumbSpremiObavijest.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val noviNaslov = et_obavijesti_naslov.text.toString()
        val novoVrijeme = et_obavijesti_vrijeme.text.toString()
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val obavijesti = ObavijestiTable(noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mObavijestViewModel.addObavijesti(obavijesti)
    }

}