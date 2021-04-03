package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoPoljoprivredaFragmentBinding
import Portal.database.table.PoljoprivredaTable
import Portal.viewModel.PoljoprivredaViewModel
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
class DodajNovoPoljoprivreda: Fragment(R.layout.dodaj_novo_poljoprivreda_fragment) {

    private val mPoljoprivredaViewModel: PoljoprivredaViewModel by viewModels()
    private lateinit var binding: DodajNovoPoljoprivredaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoPoljoprivredaFragmentBinding.bind(view)

        binding.gumbSpremiPoljoprivredu.setOnClickListener {
            if (binding.etPoljoprivredaNaslov.text.toString().trim().isEmpty()){
                binding.etPoljoprivredaNaslov.error = "Ovo polje je obavezno!"
            }else if (binding.etPoljoprivredaClanak.text.toString().trim().isEmpty()){
                binding.etPoljoprivredaClanak.error = "Ovo polje je obavezno"
            }
            else{
                insertDataToDatabase()
                val action = DodajNovoPoljoprivredaDirections.actionMenuDodajNovuPoljoprivreduToPoljoprivredaNavDrawer()
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

        val noviNaslov = binding.etPoljoprivredaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etPoljoprivredaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val poljoprivreda = PoljoprivredaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mPoljoprivredaViewModel.addPoljoprivreda(poljoprivreda)
    }

}