package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.VijestiTable
import Portal.repository.VijestiRepository
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
class VijestiViewModel @Inject constructor(
    val vijestiRepository: VijestiRepository
) : ViewModel() {

    val readAllDataVijesti = vijestiRepository.getAllDataVijesti()

    fun addVijesti(vijestiTable: VijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.addVijesti(vijestiTable)
        }
    }

    fun updateVijesti(vijestiTable: VijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.updateVijesti(vijestiTable)
        }
    }

    fun deleteVijesti(vijestiTable: VijestiTable) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteVijesti(vijestiTable)
        }
    }

    fun deleteAllVijesti() {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteAllVijesti()
        }
    }

}