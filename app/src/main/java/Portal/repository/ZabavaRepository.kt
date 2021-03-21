package Portal.repository

import Portal.database.dao.ZabavaDao
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData

class ZabavaRepository(private val zabavaDao: ZabavaDao) {

    val readAllDataZabava: LiveData<List<ZabavaTable>> = zabavaDao.getAllDataZabava()

    suspend fun addZabava(zabavaTable: ZabavaTable) {
        zabavaDao.insertZabava(zabavaTable)
    }

    suspend fun updateZabava(zabavaTable: ZabavaTable) {
        zabavaDao.updateZabava(zabavaTable)
    }

    suspend fun deleteZabava(zabavaTable: ZabavaTable) {
        zabavaDao.deleteZabava(zabavaTable)
    }

    suspend fun deleteAllZabava() {
        zabavaDao.deleteAllZabava()
    }

}