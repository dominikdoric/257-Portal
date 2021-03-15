package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.OglasnikTable
import Portal.database.table.ZabavaTable
import Portal.viewModel.OglasnikViewModel
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
import kotlinx.android.synthetic.main.dodaj_novo_oglasnik_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_oglasnik_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.et_zabava_naslov
import java.text.SimpleDateFormat
import java.util.*

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
            val action = DodajNovoOglasnikDirections.actionMenuDodajNoviOglasToOglasnikNavDrawer()
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

        val novaSlika = R.drawable.jaksic
        val noviClanak = ""
        val noviNaslov = et_oglasnik_naslov.text.toString()
        val novaCijena = et_oglasnik_cijena.text.toString()
        val novaLokacija = et_oglasnik_lokacija.text.toString()
        val noviBroj = et_oglasnik_broj.text.toString()
        val novoVrijeme = currentDate

        val oglasnik = OglasnikTable(0,novaSlika,noviClanak,noviNaslov,novaCijena,novaLokacija,noviBroj,novoVrijeme)
        mOglasnikViewModel.addOglasnik(oglasnik)
    }

}