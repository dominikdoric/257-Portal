package Portal.repository

import Portal.database.dao.VijestiDao
import Portal.database.table.SportTable
import Portal.database.table.VijestiTable
import androidx.lifecycle.LiveData

class VijestiRepository(private val vijestiDao: VijestiDao) {

    val readAllDataVijesti: LiveData<List<VijestiTable>> = vijestiDao.getAllDataVijesti()

    suspend fun addVijesti(vijestiTable: VijestiTable){
        vijestiDao.insertVijesti(vijestiTable)
    }

    suspend fun updateVijesti(vijestiTable: VijestiTable){
        vijestiDao.updateVijesti(vijestiTable)
    }

    suspend fun deleteVijesti(vijestiTable: VijestiTable){
        vijestiDao.deleteVijesti(vijestiTable)
    }

    suspend fun deleteAllVijesti(){
        vijestiDao.deleteAllVijesti()
    }

}