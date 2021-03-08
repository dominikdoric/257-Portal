package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import Portal.repository.SportRepository
import Portal.repository.ZabavaRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZabavaViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataZabava: LiveData<List<ZabavaTable>>
    private val zabavaRepository: ZabavaRepository

    init {
        val zabavaDao = Portal257Database.getDatabase(application).zabavaDao()
        zabavaRepository = ZabavaRepository(zabavaDao)
        readAllDataZabava = zabavaRepository.readAllDataZabava
    }

    fun addZabava(zabavaTable: ZabavaTable){
        viewModelScope.launch(Dispatchers.IO){
            zabavaRepository.addZabava(zabavaTable)
        }
    }

    fun updateZabava(zabavaTable: ZabavaTable){
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.updateZabava(zabavaTable)
        }
    }

    fun deleteZabava(zabavaTable: ZabavaTable){
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.deleteZabava(zabavaTable)
        }
    }

    fun deleteAllZabava(){
        viewModelScope.launch(Dispatchers.IO) {
            zabavaRepository.deleteAllZabava()
        }
    }

}