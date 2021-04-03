package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.NaslovnicaTable
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import Portal.repository.NaslovnicaRepository
import Portal.repository.SportRepository
import Portal.repository.ZabavaRepository
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
class NaslovnicaViewModel @Inject constructor(
    private val sportRepository: SportRepository,
    private val zabavaRepository: ZabavaRepository
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



    val readAllDataZabava = zabavaRepository.getAllDataZabava()

    fun addZabava(zabavaTable: ZabavaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.addZabava(zabavaTable)
        }
    }

    fun updateZabava(zabavaTable: ZabavaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.updateZabava(zabavaTable)
        }
    }

    fun deleteZabava(zabavaTable: ZabavaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.deleteZabava(zabavaTable)
        }
    }

    fun deleteAllZabava() {
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.deleteAllZabava()
        }
    }

}