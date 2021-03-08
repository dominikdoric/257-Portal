package Portal.database.dao

import Portal.database.table.NaslovnicaTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NaslovnicaDao {

    @Query("SELECT * FROM naslovnica ORDER BY id ASC")
    suspend fun getAllNaslovnica(): LiveData<List<NaslovnicaTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNaslovnica(naslovnicaTable: NaslovnicaTable)

    @Update
    suspend fun updateNaslovnica(naslovnicaTable: NaslovnicaTable)

    @Delete
    suspend fun deleteNaslovnica(naslovnicaTable: NaslovnicaTable)

    @Query(" DELETE FROM naslovnica")
    suspend fun deleteAllNaslovnica()

}