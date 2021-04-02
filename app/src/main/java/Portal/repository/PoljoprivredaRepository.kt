package Portal.repository

import Portal.database.dao.PoljoprivredaDao
import Portal.database.table.PoljoprivredaTable
import javax.inject.Inject

class PoljoprivredaRepository @Inject constructor(
    private val poljoprivredaDao: PoljoprivredaDao
)  {

    fun getAllDataPoljoprivreda() = poljoprivredaDao.getAllDataPoljoprivreda()

    suspend fun addPoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        poljoprivredaDao.insertPoljoprivreda(poljoprivredaTable)
    }

    suspend fun updatePoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        poljoprivredaDao.updatePoljoprivreda(poljoprivredaTable)
    }

    suspend fun deletePoljoprivreda(poljoprivredaTable: PoljoprivredaTable) {
        poljoprivredaDao.deletePoljoprivreda(poljoprivredaTable)
    }

    suspend fun deleteAllPoljoprivreda() {
        poljoprivredaDao.deleteAllPoljoprivreda()
    }

}