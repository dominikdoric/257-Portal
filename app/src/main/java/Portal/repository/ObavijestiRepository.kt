package Portal.repository

import Portal.database.table.ObavijestiTable
import javax.inject.Inject

class ObavijestiRepository @Inject constructor(
    private val obavijestiDao: ObavijestiDao
) {

    fun getAllDataObavijesti() = obavijestiDao.getAllDataObavijesti()

    suspend fun addObavijesti(obavijestiTable: ObavijestiTable) {
        obavijestiDao.insertObavijesti(obavijestiTable)
    }

    suspend fun updateObavijesti(obavijestiTable: ObavijestiTable) {
        obavijestiDao.updateObavijesti(obavijestiTable)
    }

    suspend fun deleteObavijesti(obavijestiTable: ObavijestiTable) {
        obavijestiDao.deleteObavijesti(obavijestiTable)
    }

    suspend fun deleteAllObavijesti() {
        obavijestiDao.deleteAllObavijesti()
    }

}