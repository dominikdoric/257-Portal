package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.ObavijestiTable
import Portal.repository.ObavijestiRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObavijestiViewModel(application: Application) : AndroidViewModel(application) {

    val readAllDataObavijesti: LiveData<List<ObavijestiTable>>
    private val obavijestiRepository: ObavijestiRepository

    init {
        val obavijestiDao = Portal257Database.getDatabase(application).obavijestiDao()
        obavijestiRepository = ObavijestiRepository(obavijestiDao)
        readAllDataObavijesti = obavijestiRepository.readAllDataObavijesti
    }

    fun addObavijesti(obavijestiTable: ObavijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            obavijestiRepository.addObavijesti(obavijestiTable)
        }
    }

    fun updateObavijesti(obavijestiTable: ObavijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            obavijestiRepository.updateObavijesti(obavijestiTable)
        }
    }

    fun deleteObavijesti(obavijestiTable: ObavijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            obavijestiRepository.deleteObavijesti(obavijestiTable)
        }
    }

    fun deleteAllObavijesti() {
        viewModelScope.launch(Dispatchers.IO) {
            obavijestiRepository.deleteAllObavijesti()
        }
    }

}