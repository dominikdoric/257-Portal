package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.OglasnikTable
import Portal.database.table.SportTable
import Portal.repository.OglasnikRepository
import Portal.repository.SportRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OglasnikViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataOglasnik: LiveData<List<OglasnikTable>>
    private val oglasnikRepository: OglasnikRepository

    init {
        val oglasnikDao = Portal257Database.getDatabase(application).oglasnikDao()
        oglasnikRepository = OglasnikRepository(oglasnikDao)
        readAllDataOglasnik = oglasnikRepository.readAllDataOglasnik
    }

    fun addOglasnik(oglasnikTable: OglasnikTable){
        viewModelScope.launch(Dispatchers.IO){
            oglasnikRepository.addOglasnik(oglasnikTable)
        }
    }

    fun updateOglasnik(oglasnikTable: OglasnikTable){
        viewModelScope.launch(Dispatchers.IO) {
            oglasnikRepository.updateOglasnik(oglasnikTable)
        }
    }

    fun deleteOglasnik(oglasnikTable: OglasnikTable){
        viewModelScope.launch(Dispatchers.IO) {
            oglasnikRepository.deleteOglasnik(oglasnikTable)
        }
    }

    fun deleteAllOglasnik(){
        viewModelScope.launch(Dispatchers.IO) {
            oglasnikRepository.deleteAllOglasnik()
        }
    }

}