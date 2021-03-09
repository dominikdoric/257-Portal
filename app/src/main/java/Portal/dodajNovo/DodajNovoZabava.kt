package Portal.dodajNovo

import Portal.a257.R
import Portal.database.table.ZabavaTable
import Portal.viewModel.ZabavaViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_zabava_fragment.view.*
import java.text.DateFormat
import java.util.*

class DodajNovoZabava: Fragment() {

    private lateinit var mZabavaViewModel: ZabavaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_zabava_fragment,container,false)

        mZabavaViewModel = ViewModelProvider(this).get(ZabavaViewModel::class.java)

        view.gumbSpremiZabavu.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val calendar = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.time)

        val noviNaslov = et_zabava_naslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val zabava = ZabavaTable(noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mZabavaViewModel.addZabava(zabava)
    }
}