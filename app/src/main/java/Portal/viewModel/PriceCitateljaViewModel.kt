package Portal.viewModel

import Portal.database.Portal257Database
import Portal.database.table.PriceCitateljaTable
import Portal.database.table.SportTable
import Portal.repository.PriceCitateljaRepository
import Portal.repository.SportRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PriceCitateljaViewModel(application: Application) : AndroidViewModel(application) {

    val readAllDataPriceCitatelja: LiveData<List<PriceCitateljaTable>>
    private val priceCitateljaRepository: PriceCitateljaRepository

    init {
        val priceCitateljaDao = Portal257Database.getDatabase(application).priceCitateljaDao()
        priceCitateljaRepository = PriceCitateljaRepository(priceCitateljaDao)
        readAllDataPriceCitatelja = priceCitateljaRepository.readAllDataPriceCitatelja
    }

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