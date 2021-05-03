package Portal.viewModel

import Portal.database.table.PriceCitateljaTable
import Portal.repository.PriceCitateljaRepository
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