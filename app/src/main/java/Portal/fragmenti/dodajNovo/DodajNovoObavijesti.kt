package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.database.table.ObavijestiTable
import Portal.dodajNovo.DodajNovoObavijestiDirections
import Portal.viewModel.ObavijestiViewModel
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
import kotlinx.android.synthetic.main.dodaj_novo_obavijesti_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_obavijesti_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoObavijesti: Fragment() {

    private val mObavijestViewModel: ObavijestiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_obavijesti_fragment,container,false)

        view.gumbSpremiObavijest.setOnClickListener {
            val action =
                DodajNovoObavijestiDirections.actionMenuDodajNovuObavijestToObavijestiNavDrawer()
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

        val noviNaslov = et_obavijesti_naslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = et_obavijesti_clanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val obavijesti = ObavijestiTable(0,noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mObavijestViewModel.addObavijesti(obavijesti)
    }
}