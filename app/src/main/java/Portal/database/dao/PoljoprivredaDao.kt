package Portal.database.dao

import Portal.database.table.PoljoprivredaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PoljoprivredaDao {

    @Query("SELECT * FROM poljoprivreda ORDER BY id DESC")
    fun getAllDataPoljoprivreda(): LiveData<List<PoljoprivredaTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPoljoprivreda(poljoprivredaTable: PoljoprivredaTable)

    @Update
    suspend fun updatePoljoprivreda(poljoprivredaTable: PoljoprivredaTable)

    @Delete
    suspend fun deletePoljoprivreda(poljoprivredaTable: PoljoprivredaTable)

    @Query(" DELETE FROM poljoprivreda")
    suspend fun deleteAllPoljoprivreda()

}