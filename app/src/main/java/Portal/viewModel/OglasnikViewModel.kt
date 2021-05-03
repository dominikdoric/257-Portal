package Portal.viewModel

import Portal.database.table.OglasnikTable
import Portal.repository.OglasnikRepository
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