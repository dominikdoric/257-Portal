package Portal.repository

import Portal.database.dao.OglasnikDao
import Portal.database.table.OglasnikTable
import androidx.lifecycle.LiveData
import javax.inject.Inject

class OglasnikRepository @Inject constructor(
    private val oglasnikDao: OglasnikDao
) {

    fun getAllOglasnikData() = oglasnikDao.getAllDataOglasnik()

    suspend fun addOglasnik(oglasnikTable: OglasnikTable) {
        oglasnikDao.insertOglasnik(oglasnikTable)
    }

    suspend fun updateOglasnik(oglasnikTable: OglasnikTable) {
        oglasnikDao.updateOglasnik(oglasnikTable)
    }

    suspend fun deleteOglasnik(oglasnikTable: OglasnikTable) {
        oglasnikDao.deleteOglasnik(oglasnikTable)
    }

    suspend fun deleteAllOglasnik() {
        oglasnikDao.deleteAllOglasnik()
    }

}