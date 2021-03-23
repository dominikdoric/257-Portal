package Portal.database.dao

import Portal.database.table.InfoTable
import Portal.database.table.SportTable
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface InfoDao {

    @Query("SELECT * FROM info ORDER BY id ASC")
    fun getAllDataInfo(): LiveData<List<InfoTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInfo(infoTable: InfoTable)

    @Delete
    suspend fun deleteInfo(infoTable: InfoTable)

}