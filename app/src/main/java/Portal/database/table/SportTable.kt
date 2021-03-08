package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport")
data class SportTable (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "sport_naslov")
    val sportNaslov: String,

    @ColumnInfo(name = "sport_clanak")
    val sportClanak: String,

    @ColumnInfo(name = "sport_vrijeme")
    val sportVrijeme: String,

    @ColumnInfo(name = "sport_slika")
    val sportSlika: Int

        )