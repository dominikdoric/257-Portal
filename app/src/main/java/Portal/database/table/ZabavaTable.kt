package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "zabava")
data class ZabavaTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "zabava_naslov")
    val zabavaNaslov: String,

    @ColumnInfo(name = "zabava_clanak")
    val zabavaClanak: String,

    @ColumnInfo(name = "zabava_vrijeme")
    val zabavaVrijeme: String,

    @ColumnInfo(name = "zabava_slika")
    val zabavaSlika: Int
) : Parcelable