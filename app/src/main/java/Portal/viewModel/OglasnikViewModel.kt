package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.OglasnikTable
import Portal.database.table.SportTable
import Portal.repository.OglasnikRepository
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
class OglasnikViewModel @Inject constructor(
    val oglasnikRepository: OglasnikRepository
): ViewModel() {

    val readAllDataOglasnik = oglasnikRepository.getAllOglasnikData()

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