package Portal.viewModel

import Portal.database.table.PoljoprivredaTable
import Portal.database.table.SportTable
import Portal.repository.PoljoprivredaRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoljoprivredaViewModel @Inject constructor(
    val poljoprivredaRepository: PoljoprivredaRepository
) : ViewModel() {

    val readAllDataPoljoprivreda = poljoprivredaRepository.getAllDataPoljoprivreda()

    fun addPoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            poljoprivredaRepository.addPoljoprivreda(poljoprivredaTable)
        }
    }

    fun updatePoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            poljoprivredaRepository.updatePoljoprivreda(poljoprivredaTable)
        }
    }

    fun deletePoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            poljoprivredaRepository.deletePoljoprivreda(poljoprivredaTable)
        }
    }

    fun deleteAllPoljoprivreda() {
        viewModelScope.launch(Dispatchers.IO) {
            poljoprivredaRepository.deleteAllPoljoprivreda()
        }
    }

}