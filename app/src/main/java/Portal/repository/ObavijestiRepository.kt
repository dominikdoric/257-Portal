package Portal.repository

import Portal.database.dao.ObavijestiDao
import Portal.database.table.ObavijestiTable
import Portal.database.table.SportTable
import androidx.lifecycle.LiveData

class ObavijestiRepository(private val obavijestiDao: ObavijestiDao) {

    val readAllDataObavijesti: LiveData<List<ObavijestiTable>> = obavijestiDao.getAllDataObavijesti()

    suspend fun addObavijesti(obavijestiTable: ObavijestiTable){
        obavijestiDao.insertObavijesti(obavijestiTable)
    }

    suspend fun updateObavijesti(obavijestiTable: ObavijestiTable){
        obavijestiDao.updateObavijesti(obavijestiTable)
    }

    suspend fun deleteObavijesti(obavijestiTable: ObavijestiTable){
        obavijestiDao.deleteObavijesti(obavijestiTable)
    }

    suspend fun deleteAllObavijesti(){
        obavijestiDao.deleteAllObavijesti()
    }

}