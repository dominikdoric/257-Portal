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
        val noviNaslov = et_zabava_naslov.text.toString()
        val novoVrijeme = et_zabava_vrijeme.text.toString()
        val noviClanak = ""
        val novaSlika = R.drawable.jaksic

        val zabava = ZabavaTable(0,noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mZabavaViewModel.addZabava(zabava)
    }
}