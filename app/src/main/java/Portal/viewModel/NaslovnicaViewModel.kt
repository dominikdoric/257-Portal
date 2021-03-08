package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.NaslovnicaTable
import Portal.database.table.SportTable
import Portal.repository.NaslovnicaRepository
import Portal.repository.SportRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NaslovnicaViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataNaslovnica: LiveData<List<NaslovnicaTable>>
    private val naslovnicaRepository: NaslovnicaRepository

    init {
        val naslovnicaDao = Portal257Database.getDatabase(application).naslovnicaDao()
        naslovnicaRepository = NaslovnicaRepository(naslovnicaDao)
        readAllDataNaslovnica = naslovnicaRepository.readAllDataNaslovnica
    }

    fun addNaslovnica(naslovnicaTable: NaslovnicaTable){
        viewModelScope.launch(Dispatchers.IO){
            naslovnicaRepository.addNaslovnica(naslovnicaTable)
        }
    }

    fun updateNaslovnica(naslovnicaTable: NaslovnicaTable){
        viewModelScope.launch(Dispatchers.IO) {
            naslovnicaRepository.updateNaslovnica(naslovnicaTable)
        }
    }

    fun deleteNaslovnica(naslovnicaTable: NaslovnicaTable){
        viewModelScope.launch(Dispatchers.IO) {
            naslovnicaRepository.deleteNaslovnica(naslovnicaTable)
        }
    }

    fun deleteAllNaslovnica(){
        viewModelScope.launch(Dispatchers.IO) {
            naslovnicaRepository.deleteAllNaslovnica()
        }
    }

}