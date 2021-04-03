package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoPriceCitateljaFragmentBinding
import Portal.database.table.PriceCitateljaTable
import Portal.viewModel.PriceCitateljaViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dodaj_novo_price_citatelja_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_price_citatelja_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoPriceCitatelja : Fragment(R.layout.dodaj_novo_price_citatelja_fragment) {

    private val mPriceCitateljaViewModel: PriceCitateljaViewModel by viewModels()
    private lateinit var binding: DodajNovoPriceCitateljaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoPriceCitateljaFragmentBinding.bind(view)

        binding.gumbSpremiPriceCitatelja.setOnClickListener {
            if (binding.etPriceCitateljaNaslov.text.toString().trim().isEmpty()){
                binding.etPriceCitateljaNaslov.error = "Ovo polje je obavezno!"
            }else if (binding.etPriceCitateljaClanak.text.toString().trim().isEmpty()){
                binding.etPriceCitateljaClanak.error = "Ovo polje je obavezno"
            }
            else{
                insertDataToDatabase()
                val action = DodajNovoPriceCitateljaDirections.actionMenuDodajNovuPricuCitateljaToPriceCitateljaNavDrawer()
                findNavController().navigate(action)
                Toast.makeText(
                    requireContext(),
                    "Vaš članak je zaprimljen te je poslan adminu na odobrenje.Hvala!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.etPriceCitateljaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etPriceCitateljaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val priceCitatelja = PriceCitateljaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mPriceCitateljaViewModel.addPriceCitatelja(priceCitatelja)
    }

}