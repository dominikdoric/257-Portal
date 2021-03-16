package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "price_citatelja")
data class PriceCitateljaTable (
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "priceCitatelja_naslov")
    val priceCitateljaNaslov: String,

    @ColumnInfo(name = "priceCitatelja_clanak")
    val priceCitateljaClanak: String,

    @ColumnInfo(name = "priceCitatelja_vrijeme")
    val priceCitateljaVrijeme: String,

    @ColumnInfo(name = "priceCitatelja_slika")
    val priceCitateljaSlika: Int
        ): Parcelable