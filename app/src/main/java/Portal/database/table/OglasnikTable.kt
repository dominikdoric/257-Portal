package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "oglasnik")
data class OglasnikTable (

    @ColumnInfo(name = "oglasnik_naslov")
    val oglasnikNaslov: String,

    @ColumnInfo(name = "oglasnik_clanak")
    val oglasnikClanak: String,

    @ColumnInfo(name = "oglasnik_vrijeme")
    val oglasnikVrijeme: String,

    @ColumnInfo(name = "oglasnik_slika")
    val oglasnikSlika: Int
        )
{
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

}