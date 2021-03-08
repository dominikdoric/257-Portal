package Portal.repository

import Portal.database.dao.NaslovnicaDao
import Portal.database.table.NaslovnicaTable
import Portal.database.table.SportTable
import androidx.lifecycle.LiveData

class NaslovnicaRepository(private val naslovnicaDao: NaslovnicaDao) {

    val readAllDataNaslovnica: LiveData<List<NaslovnicaTable>> = naslovnicaDao.getAllDataNaslovnica()

    suspend fun addNaslovnica(naslovnicaTable: NaslovnicaTable){
        naslovnicaDao.insertNaslovnica(naslovnicaTable)
    }

    suspend fun updateNaslovnica(naslovnicaTable: NaslovnicaTable){
        naslovnicaDao.updateNaslovnica(naslovnicaTable)
    }

    suspend fun deleteNaslovnica(naslovnicaTable: NaslovnicaTable){
        naslovnicaDao.deleteNaslovnica(naslovnicaTable)
    }

    suspend fun deleteAllNaslovnica(){
        naslovnicaDao.deleteAllNaslovnica()
    }

}