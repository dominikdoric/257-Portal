package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zabava")
data class ZabavaTable (

    @ColumnInfo(name = "zabava_naslov")
    val zabavaNaslov: String,

    @ColumnInfo(name = "zabava_clanak")
    val zabavaClanak: String,

    @ColumnInfo(name = "zabava_vrijeme")
    val zabavaVrijeme: String,

    @ColumnInfo(name = "zabava_slika")
    val zabavaSlika: Int
        )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}