package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.ObavijestiTable
import Portal.repository.ObavijestiRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObavijestiViewModel @Inject constructor(
    val obavijestiRepository: ObavijestiRepository
) : ViewModel() {

    val readAllDataObavijesti = obavijestiRepository.getAllDataObavijesti()

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