package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoSportFragmentBinding
import Portal.database.table.SportTable
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
class DodajNovoSport : Fragment(R.layout.dodaj_novo_sport_fragment) {

    private val mSportViewModel: SportViewModel by viewModels()
    private lateinit var binding: DodajNovoSportFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoSportFragmentBinding.bind(view)

        binding.gumbSpremiSport.setOnClickListener {
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

    }

    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etSportNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etSportClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val sport = SportTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mSportViewModel.addSport(sport)
    }

}