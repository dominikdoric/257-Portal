package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoObavijestiFragmentBinding
import Portal.database.table.ObavijestiTable
import Portal.viewModel.ObavijestiViewModel
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
class DodajNovoObavijesti : Fragment(R.layout.dodaj_novo_obavijesti_fragment) {

    private val mObavijestViewModel: ObavijestiViewModel by viewModels()
    private lateinit var binding: DodajNovoObavijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoObavijestiFragmentBinding.bind(view)

        binding.gumbSpremiObavijest.setOnClickListener {
            if (binding.etObavijestiNaslov.text.toString().trim().isEmpty()){
                binding.etObavijestiNaslov.error = "Ovo polje je obavezno!"
            }else if (binding.etObavijestiClanak.text.toString().trim().isEmpty()){
                binding.etObavijestiClanak.error = "Ovo polje je obavezno"
            }
            else{
                insertDataToDatabase()
                val action = DodajNovoObavijestiDirections.actionMenuDodajNovuObavijestToObavijestiNavDrawer()
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

        val noviNaslov = binding.etObavijestiNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etObavijestiClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val obavijesti = ObavijestiTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mObavijestViewModel.addObavijesti(obavijesti)
    }
}