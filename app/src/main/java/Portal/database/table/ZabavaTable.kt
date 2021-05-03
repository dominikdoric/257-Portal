package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class ZabavaTable(

    val zabavaNaslov: String = "",

    val zabavaClanak: String = "",

    val zabavaVrijeme: String = ""
) : Parcelable