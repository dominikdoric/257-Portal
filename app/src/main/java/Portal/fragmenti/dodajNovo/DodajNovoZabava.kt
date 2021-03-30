package Portal.fragmenti.dodajNovo

import Portal.a257.R
import Portal.a257.databinding.DodajNovoZabavaFragmentBinding
import Portal.database.table.ZabavaTable
import Portal.viewModel.ZabavaViewModel
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
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovoZabava : Fragment(R.layout.dodaj_novo_zabava_fragment) {

    private val mZabavaViewModel: ZabavaViewModel by viewModels()

    private lateinit var binding: DodajNovoZabavaFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DodajNovoZabavaFragmentBinding.bind(view)
        binding.gumbSpremiZabavu.setOnClickListener {
            val action = DodajNovoZabavaDirections.actionMenuDodajNovuZabavaToZabavaNavDrawer()
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

        val noviNaslov = binding.etZabavaNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.etZabavaClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val zabava = ZabavaTable(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mZabavaViewModel.addZabava(zabava)
    }
}