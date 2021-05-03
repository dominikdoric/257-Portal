package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class PoljoprivredaTable(

    val poljoprivredaNaslov: String = "",

    val poljoprivredaClanak: String = "",

    val poljoprivredaVrijeme: String = ""
) : Parcelable