package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vijesti")
data class VijestiTable (

    @ColumnInfo(name = "vijesti_naslov")
    val vijestiNaslov: String,

    @ColumnInfo(name = "vijesti_clanak")
    val vijestiClanak: String,

    @ColumnInfo(name = "vijesti_vrijeme")
    val vijestiVrijeme: String,

    @ColumnInfo(name = "vijesti_slika")
    val vijestiSlika: Int
        )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}