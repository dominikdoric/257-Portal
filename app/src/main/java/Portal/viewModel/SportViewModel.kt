package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.SportTable
import Portal.repository.SportRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SportViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataSport: LiveData<List<SportTable>>
    private val sportRepository: SportRepository

    init {
        val sportDao = Portal257Database.getDatabase(application).sportDao()
        sportRepository = SportRepository(sportDao)
        readAllDataSport = sportRepository.readAllDataSport
    }

    fun addSport(sportTable: SportTable){
        viewModelScope.launch(Dispatchers.IO){
            sportRepository.addSport(sportTable)
        }
    }

    fun updateRaspored(sportTable: SportTable){
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.updateSport(sportTable)
        }
    }

    fun deleteRaspored(sportTable: SportTable){
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.deleteSport(sportTable)
        }
    }

    fun deleteAllRaspored(){
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.deleteAllSport()
        }
    }
}