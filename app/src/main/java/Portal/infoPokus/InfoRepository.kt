package Portal.infoPokus

import Portal.database.dao.InfoDao
import Portal.database.table.InfoTable
import javax.inject.Inject

class InfoRepository  @Inject constructor(
    val infoDao: InfoDao
){

    fun getAllDataInfo() = infoDao.getAllDataInfo()

    suspend fun insertInfo(infoTable: InfoTable) = infoDao.insertInfo(infoTable)

    suspend fun updateInfo(infoTable: InfoTable) = infoDao.updateInfo(infoTable)

    suspend fun deleteInfo(infoTable: InfoTable) = infoDao.deleteInfo(infoTable)


}