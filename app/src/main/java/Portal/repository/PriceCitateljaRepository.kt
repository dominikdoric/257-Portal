package Portal.repository

import Portal.database.table.PriceCitateljaTable
import javax.inject.Inject

class PriceCitateljaRepository @Inject constructor(
    private val priceCitateljaDao: PriceCitateljaDao
) {

    fun getAllDataPriceCitatelja() = priceCitateljaDao.getAllDataPriceCitatelja()

    suspend fun addPriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        priceCitateljaDao.insertPriceCitatelja(priceCitateljaTable)
    }

    suspend fun updatePriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        priceCitateljaDao.updatePriceCitatelja(priceCitateljaTable)
    }

    suspend fun deletePriceCitatelja(priceCitateljaTable: PriceCitateljaTable) {
        priceCitateljaDao.deletePriceCitatelja(priceCitateljaTable)
    }

    suspend fun deleteAllPriceCitatelja() {
        priceCitateljaDao.deleteAllPriceCitatelja()
    }

}