package Portal.database.dao

import Portal.database.table.VijestiTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VijestiDao {

    @Query("SELECT * FROM vijesti ORDER BY id ASC")
    fun getAllDataVijesti(): LiveData<List<VijestiTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVijesti(vijestiTable: VijestiTable)

    @Update
    suspend fun updateVijesti(vijestiTable: VijestiTable)

    @Delete
    suspend fun deleteVijesti(vijestiTable: VijestiTable)

    @Query(" DELETE FROM vijesti")
    suspend fun deleteAllVijesti()

}