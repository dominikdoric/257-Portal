package Portal.database.dao

import Portal.database.table.OglasnikTable
import Portal.database.table.ZabavaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OglasnikDao {

    @Query("SELECT * FROM oglasnik ORDER BY id DESC")
    fun getAllDataOglasnik(): LiveData<List<OglasnikTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOglasnik(oglasnikTable: OglasnikTable)

    @Update
    suspend fun updateOglasnik(oglasnikTable: OglasnikTable)

    @Delete
    suspend fun deleteOglasnik(oglasnikTable: OglasnikTable)

    @Query(" DELETE FROM oglasnik")
    suspend fun deleteAllOglasnik()

}