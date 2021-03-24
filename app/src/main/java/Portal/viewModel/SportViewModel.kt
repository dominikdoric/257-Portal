package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.SportTable
import Portal.repository.SportRepository
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
class SportViewModel @Inject constructor(
    val sportRepository: SportRepository
) : ViewModel() {

    val readAllDataSport = sportRepository.getAllDataSport()

    fun addSport(sportTable: SportTable) {
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.addSport(sportTable)
        }
    }

    fun updateSport(sportTable: SportTable) {
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.updateSport(sportTable)
        }
    }

    fun deleteSport(sportTable: SportTable) {
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.deleteSport(sportTable)
        }
    }

    fun deleteAllSport() {
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.deleteAllSport()
        }
    }
}