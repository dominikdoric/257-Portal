package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class ObavijestiTable(

    val obavijestiNaslov: String,

    val obavijestiClanak: String,

    val obavijestiVrijeme: String,

    val obavijestiSlika: Int
) : Parcelable