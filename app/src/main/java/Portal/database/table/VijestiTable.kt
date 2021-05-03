package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class VijestiTable(

    val vijestiNaslov: String = "",

    val vijestiClanak: String = "",

    val vijestiVrijeme: String = ""
) : Parcelable