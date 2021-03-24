package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.PriceCitateljaTable
import Portal.database.table.SportTable
import Portal.repository.PriceCitateljaRepository
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
class PriceCitateljaViewModel @Inject constructor(
    val priceCitateljaRepository: PriceCitateljaRepository
) : ViewModel() {

    val readAllDataPriceCitatelja = priceCitateljaRepository.getAllDataPriceCitatelja()

    fun addPriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            priceCitateljaRepository.addPriceCitatelja(priceCitateljaTable)
        }
    }

    fun updatePriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            priceCitateljaRepository.updatePriceCitatelja(priceCitateljaTable)
        }
    }

    fun deletePriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        viewModelScope.launch(Dispatchers.IO) {
            priceCitateljaRepository.deletePriceCitatelja(priceCitateljaTable)
        }
    }

    fun deleteAllPriceCitatelja() {
        viewModelScope.launch(Dispatchers.IO) {
            priceCitateljaRepository.deleteAllPriceCitatelja()
        }
    }

}