package Portal.repository

import Portal.database.table.VijestiTable
import javax.inject.Inject

class VijestiRepository @Inject constructor(
    private val vijestiDao: VijestiDao
) {

    fun getAllDataVijesti() = vijestiDao.getAllDataVijesti()

    suspend fun addVijesti(vijestiTable: VijestiTable) {
        vijestiDao.insertVijesti(vijestiTable)
    }

    suspend fun updateVijesti(vijestiTable: VijestiTable) {
        vijestiDao.updateVijesti(vijestiTable)
    }

    suspend fun deleteVijesti(vijestiTable: VijestiTable) {
        vijestiDao.deleteVijesti(vijestiTable)
    }

    suspend fun deleteAllVijesti() {
        vijestiDao.deleteAllVijesti()
    }

}