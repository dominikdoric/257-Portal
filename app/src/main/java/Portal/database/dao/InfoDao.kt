package Portal.database.dao

import Portal.database.table.InfoTable
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface InfoDao {

    @Query("SELECT * FROM info ORDER BY id DESC")
    fun getAllDataInfo(): LiveData<List<InfoTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInfo(infoTable: InfoTable)

    @Update
    suspend fun updateInfo(infoTable: InfoTable)

    @Delete
    suspend fun deleteInfo(infoTable: InfoTable)

}