package Portal.repository

import Portal.database.dao.SportDao
import Portal.database.table.SportTable
import androidx.lifecycle.LiveData
import javax.inject.Inject

class SportRepository @Inject constructor(
    private val sportDao: SportDao
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

}