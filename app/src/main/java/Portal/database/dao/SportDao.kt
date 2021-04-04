package Portal.database.dao

import Portal.database.table.SportTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SportDao {

    @Query("SELECT * FROM sport ORDER BY id DESC")
    fun getAllDataSport(): LiveData<List<SportTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSport(sportTable: SportTable)

    @Update
    suspend fun updateSport(sportTable: SportTable)

    @Delete
    suspend fun deleteSport(sportTable: SportTable)

    @Query(" DELETE FROM sport")
    suspend fun deleteAllSport()

}