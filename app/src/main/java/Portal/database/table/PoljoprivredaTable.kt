package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "poljoprivreda")
data class PoljoprivredaTable(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "poljoprivreda_naslov")
    val poljoprivredaNaslov: String,

    @ColumnInfo(name = "poljoprivreda_clanak")
    val poljoprivredaClanak: String,

    @ColumnInfo(name = "poljoprivreda_vrijeme")
    val poljoprivredaVrijeme: String,

    @ColumnInfo(name = "poljoprivreda_slika")
    val poljoprivredaSlika: Int
): Parcelable