package Portal.database.dao

import Portal.database.table.ObavijestiTable
import Portal.database.table.PriceCitateljaTable
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PriceCitateljaDao {

    @Query("SELECT * FROM price_citatelja ORDER BY id DESC")
    fun getAllDataPriceCitatelja(): LiveData<List<PriceCitateljaTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPriceCitatelja(priceCitateljaTable: PriceCitateljaTable)

    @Update
    suspend fun updatePriceCitatelja(priceCitateljaTable: PriceCitateljaTable)

    @Delete
    suspend fun deletePriceCitatelja(priceCitateljaTable: PriceCitateljaTable)

    @Query(" DELETE FROM price_citatelja")
    suspend fun deleteAllPriceCitatelja()

}