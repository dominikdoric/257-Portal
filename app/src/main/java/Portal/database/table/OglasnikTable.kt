package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "oglasnik")
data class OglasnikTable (

    @ColumnInfo(name = "oglasnik_slika")
    val oglasnikSlika: Int,

    @ColumnInfo(name = "oglasnik_clanak")
    val oglasnikClanak: String,

    @ColumnInfo(name = "oglasnik_naslov")
    val oglasnikNaslov: String,

    @ColumnInfo(name = "oglasnik_cijena")
    val oglasnikCijena: String,

    @ColumnInfo(name = "oglasnik_lokacija")
    val oglasnikLokacija: String,

    @ColumnInfo(name = "oglasnik_broj")
    val oglasnikBroj: String
        )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}