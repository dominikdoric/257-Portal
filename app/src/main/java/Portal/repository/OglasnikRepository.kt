package Portal.repository

import Portal.database.dao.OglasnikDao
import Portal.database.table.OglasnikTable
import androidx.lifecycle.LiveData

class OglasnikRepository(private val oglasnikDao: OglasnikDao) {

    val readAllDataOglasnik: LiveData<List<OglasnikTable>> = oglasnikDao.getAllDataOglasnik()

    suspend fun addOglasnik(oglasnikTable: OglasnikTable){
        oglasnikDao.insertOglasnik(oglasnikTable)
    }

    suspend fun updateOglasnik(oglasnikTable: OglasnikTable){
        oglasnikDao.updateOglasnik(oglasnikTable)
    }

    suspend fun deleteOglasnik(oglasnikTable: OglasnikTable){
        oglasnikDao.deleteOglasnik(oglasnikTable)
    }

    suspend fun deleteAllOglasnik(){
        oglasnikDao.deleteAllOglasnik()
    }

}