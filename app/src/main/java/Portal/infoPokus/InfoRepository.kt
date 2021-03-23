package Portal.infoPokus

import Portal.database.dao.InfoDao
import Portal.database.dao.SportDao
import Portal.database.table.InfoTable
import Portal.database.table.SportTable
import javax.inject.Inject

class InfoRepository  @Inject constructor(
    val infoDao: InfoDao
){
    suspend fun insertInfo(infoTable: InfoTable) = infoDao.insertInfo(infoTable)

    suspend fun deleteInfo(infoTable: InfoTable) = infoDao.deleteInfo(infoTable)


}