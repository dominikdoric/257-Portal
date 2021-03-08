package Portal.database.dao

import Portal.database.table.ObavijestiTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ObavijestiDao {

    @Query("SELECT * FROM obavijesti ORDER BY id ASC")
    fun getAllDataObavijesti(): LiveData<List<ObavijestiTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertObavijesti(obavijestiTable: ObavijestiTable)

    @Update
    suspend fun updateObavijesti(obavijestiTable: ObavijestiTable)

    @Delete
    suspend fun deleteObavijesti(obavijestiTable: ObavijestiTable)

    @Query(" DELETE FROM obavijesti")
    suspend fun deleteAllObavijesti()


}