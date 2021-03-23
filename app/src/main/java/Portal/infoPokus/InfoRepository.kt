package Portal.infoPokus

import Portal.database.dao.SportDao
import Portal.database.table.SportTable
import javax.inject.Inject

class InfoRepository  @Inject constructor(
    val sportDao: SportDao
){
    suspend fun insertSport(sportTable: SportTable) = sportDao.insertSport(sportTable)

    suspend fun deleteSport(sportTable: SportTable) = sportDao.deleteSport(sportTable)

    suspend fun getSport(sportTable: SportTable) = sportDao.getAllDataSport()
}