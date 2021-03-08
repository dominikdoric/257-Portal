package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.VijestiTable
import Portal.repository.VijestiRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VijestiViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataVijesti: LiveData<List<VijestiTable>>
    private val vijestiRepository: VijestiRepository

    init {
        val vijestiDao = Portal257Database.getDatabase(application).vijestiDao()
        vijestiRepository = VijestiRepository(vijestiDao)
        readAllDataVijesti = vijestiRepository.readAllDataVijesti
    }

    fun addVijesti(vijestiTable: VijestiTable){
        viewModelScope.launch(Dispatchers.IO){
            vijestiRepository.addVijesti(vijestiTable)
        }
    }

    fun updateVijesti(vijestiTable: VijestiTable){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.updateVijesti(vijestiTable)
        }
    }

    fun deleteVijesti(vijestiTable: VijestiTable){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteVijesti(vijestiTable)
        }
    }

    fun deleteAllVijesti(){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteAllVijesti()
        }
    }

}