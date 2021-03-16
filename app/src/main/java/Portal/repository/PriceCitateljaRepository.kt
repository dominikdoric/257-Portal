package Portal.repository

import Portal.database.dao.PriceCitateljaDao
import Portal.database.table.PriceCitateljaTable
import Portal.database.table.SportTable
import androidx.lifecycle.LiveData

class PriceCitateljaRepository(private val priceCitateljaDao: PriceCitateljaDao) {

    val readAllDataPriceCitatelja: LiveData<List<PriceCitateljaTable>> = priceCitateljaDao.getAllDataPriceCitatelja()

    suspend fun addPriceCitatelja(priceCitateljaTable: PriceCitateljaTable){
        priceCitateljaDao.insertPriceCitatelja(priceCitateljaTable)
    }

    suspend fun updatePriceCitatelja(priceCitateljaTable: PriceCitateljaTable){
        priceCitateljaDao.updatePriceCitatelja(priceCitateljaTable)
    }

    suspend fun deletePriceCitatelja(priceCitateljaTable: PriceCitateljaTable){
        priceCitateljaDao.deletePriceCitatelja(priceCitateljaTable)
    }

    suspend fun deleteAllPriceCitatelja(){
        priceCitateljaDao.deleteAllPriceCitatelja()
    }

}