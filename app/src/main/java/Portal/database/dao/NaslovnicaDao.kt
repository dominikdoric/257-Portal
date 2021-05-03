package Portal.database.dao

import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NaslovnicaDao {

    @Query("SELECT * FROM zabava ORDER BY id ASC")
    fun getAllDataZabava(): LiveData<List<ZabavaTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertZabava(zabavaTable: ZabavaTable)

    @Update
    suspend fun updateZabava(zabavaTable: ZabavaTable)

    @Delete
    suspend fun deleteZabava(zabavaTable: ZabavaTable)

    @Query(" DELETE FROM zabava")
    suspend fun deleteAllZabava()

}