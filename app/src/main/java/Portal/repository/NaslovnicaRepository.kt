package Portal.repository

import Portal.database.dao.NaslovnicaDao
import Portal.database.dao.SportDao
import Portal.database.dao.ZabavaDao
import Portal.database.table.NaslovnicaTable
import Portal.database.table.SportTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import javax.inject.Inject

class NaslovnicaRepository @Inject constructor(
    private val sportDao: SportDao,
    private val zabavaDao: ZabavaDao
) {
    fun getAllDataSport() = sportDao.getAllDataSport()

    suspend fun addSport(sportTable: SportTable) {
        sportDao.insertSport(sportTable)
    }

    suspend fun updateSport(sportTable: SportTable) {
        sportDao.updateSport(sportTable)
    }

    suspend fun deleteSport(sportTable: SportTable) {
        sportDao.deleteSport(sportTable)
    }

    suspend fun deleteAllSport() {
        sportDao.deleteAllSport()
    }


    fun getAllDataZabava() = zabavaDao.getAllDataZabava()

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