package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "vijesti")
data class VijestiTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "vijesti_naslov")
    val vijestiNaslov: String,

    @ColumnInfo(name = "vijesti_clanak")
    val vijestiClanak: String,

    @ColumnInfo(name = "vijesti_vrijeme")
    val vijestiVrijeme: String,

    @ColumnInfo(name = "vijesti_slika")
    val vijestiSlika: Int
) : Parcelable