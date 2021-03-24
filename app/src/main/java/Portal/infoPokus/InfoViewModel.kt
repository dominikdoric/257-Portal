package Portal.infoPokus

import Portal.database.table.InfoTable
import Portal.database.table.SportTable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    val infoRepository: InfoRepository
) : ViewModel() {

    val readAllDataInfo = infoRepository.getAllDataInfo()

    fun addInfo(infoTable: InfoTable) {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.insertInfo(infoTable)
        }
    }

}