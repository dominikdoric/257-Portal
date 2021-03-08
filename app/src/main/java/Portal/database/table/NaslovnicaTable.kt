package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "naslovnica")
data class NaslovnicaTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "naslovnica_naslov")
    val naslovnicaNaslov: String,

    @ColumnInfo(name = "naslovnica_clanak")
    val naslovnicaClanak: String,

    @ColumnInfo(name = "naslovnica_vrijeme")
    val naslovnicaVrijeme: String,

    @ColumnInfo(name = "naslovnica_slika")
    val naslovnicaSlika: Int
)