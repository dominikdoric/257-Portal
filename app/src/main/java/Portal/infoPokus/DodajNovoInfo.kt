package Portal.infoPokus

import Portal.a257.R
import Portal.database.table.InfoTable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dodaj_novo_info_fragment.*
import kotlinx.android.synthetic.main.dodaj_novo_info_fragment.view.*

class DodajNovoInfo: Fragment() {

    private val infoViewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dodaj_novo_info_fragment,container,false)

        view.gumbSpremiInfo.setOnClickListener {
            val action = DodajNovoInfoDirections.actionDodajNovoInfoToInfoBottomNav()
            findNavController().navigate(action)
        }

        return view
    }

    private fun insertDataToDatabase(){
        val novoImeInfo = novoInfoIme.text.toString()
        val novoPrezimeInfo = novoInfoPrezime.text.toString()

        val info = InfoTable(0,novoImeInfo,novoPrezimeInfo)
        infoViewModel.addInfo(info)
    }

}