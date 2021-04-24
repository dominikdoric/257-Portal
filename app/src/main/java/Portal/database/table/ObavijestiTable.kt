package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "obavijesti")
data class ObavijestiTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "obavijesti_naslov")
    val obavijestiNaslov: String,

    @ColumnInfo(name = "obavijesti_clanak")
    val obavijestiClanak: String,

    @ColumnInfo(name = "obavijesti_vrijeme")
    val obavijestiVrijeme: String,

    @ColumnInfo(name = "obavijesti_slika")
    val obavijestiSlika: Int
) : Parcelable