package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoOglasnikFragmentBinding
import Portal.database.table.OglasnikTable
import Portal.viewModel.OglasnikViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoOglasnik : Fragment(R.layout.dodaj_novo_oglasnik_fragment) {

    private val mOglasnikViewModel: OglasnikViewModel by viewModels()
    private lateinit var binding: DodajNovoOglasnikFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoOglasnikFragmentBinding.bind(view)

        binding.gumbSpremiOglasnik.setOnClickListener {
            if (binding.etOglasnikNaslov.text.toString().trim().isEmpty()) {
                binding.etOglasnikNaslov.error = "Ovo polje je obavezno!"
            } else if (binding.etOglasnikCijena.text.toString().trim().isEmpty()) {
                binding.etOglasnikCijena.error = "Ovo polje je obavezno"
            } else if (binding.etOglasnikLokacija.text.toString().trim().isEmpty()) {
                binding.etOglasnikLokacija.error = "Ovo polje je obavezno"
            } else if (binding.etOglasnikBroj.text.toString().trim().isEmpty()) {
                binding.etOglasnikBroj.error = "Ovo polje je obavezno"
            } else if (binding.etOglasnikClanak.text.toString().trim().isEmpty()) {
                binding.etOglasnikClanak.error = "Ovo polje je obavezno"
            } else {
                insertDataToDatabase()
                val action =
                    DodajNovoOglasnikDirections.actionMenuDodajNoviOglasToOglasnikNavDrawer()
                findNavController().navigate(action)
                Toast.makeText(
                    requireContext(),
                    "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val novaSlika = R.drawable.jaksic
        val noviClanak = binding.etOglasnikClanak.text.toString()
        val noviNaslov = binding.etOglasnikNaslov.text.toString()
        val novaCijena = binding.etOglasnikCijena.text.toString()
        val novaLokacija = binding.etOglasnikLokacija.text.toString()
        val noviBroj = binding.etOglasnikBroj.text.toString()
        val novoVrijeme = currentDate

        val oglasnik = OglasnikTable(
            0,
            novaSlika,
            noviClanak,
            noviNaslov,
            novaCijena,
            novaLokacija,
            noviBroj,
            novoVrijeme
        )
        mOglasnikViewModel.addOglasnik(oglasnik)
    }

}