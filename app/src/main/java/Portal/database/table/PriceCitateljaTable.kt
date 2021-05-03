package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceCitateljaTable(

    val priceCitateljaNaslov: String = "",

    val priceCitateljaClanak: String = "",

    val priceCitateljaVrijeme: String = ""
) : Parcelable