package Portal.di

import Portal.database.dao.SportDao
import Portal.database.table.SportTable
import javax.inject.Inject

class MainRepository  @Inject constructor(
    val sportDao: SportDao
){
    suspend fun insertSport(sportTable: SportTable) = sportDao.insertSport(sportTable)

    suspend fun deleteSport(sportTable: SportTable) = sportDao.deleteSport(sportTable)

    suspend fun getSport(sportTable: SportTable) = sportDao.getAllDataSport()
}