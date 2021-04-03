package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "naslovnica")
data class NaslovnicaTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "naslovnica_naslov")
    val naslovnicaSportNaslov: String,

    @ColumnInfo(name = "naslovnica_clanak")
    val naslovnicaSportClanak: String,

    @ColumnInfo(name = "naslovnica_vrijeme")
    val naslovnicaSportVrijeme: String,

    @ColumnInfo(name = "naslovnica_slika")
    val naslovnicaSportSlika: Int,

    @ColumnInfo(name = "naslovnica_naslov")
    val naslovnicaZabavaNaslov: String,

    @ColumnInfo(name = "naslovnica_clanak")
    val naslovnicaZabavaClanak: String,

    @ColumnInfo(name = "naslovnica_vrijeme")
    val naslovnicaZabavaVrijeme: String,

    @ColumnInfo(name = "naslovnica_slika")
    val naslovnicaZabavaSlika: Int
)