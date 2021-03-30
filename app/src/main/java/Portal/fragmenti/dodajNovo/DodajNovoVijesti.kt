package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoVijestiFragmentBinding
import Portal.database.table.VijestiTable
import Portal.viewModel.VijestiViewModel
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
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_vijesti_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoVijesti : Fragment(R.layout.dodaj_novo_vijesti_fragment) {

    private val mVijestiViewModel: VijestiViewModel by viewModels()

    private lateinit var binding: DodajNovoVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoVijestiFragmentBinding.bind(view)

        binding.gumbSpremiVijest.setOnClickListener {
            val action = DodajNovoVijestiDirections.actionMenuDodajNovuVijestToVijestiNavDrawer()
            findNavController().navigate(action)
            Toast.makeText(
                requireContext(),
                "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                Toast.LENGTH_LONG
            )
                .show()
            insertDataToDatabase()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etVijestiNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etVijestiClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val vijesti = VijestiTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mVijestiViewModel.addVijesti(vijesti)
    }

}