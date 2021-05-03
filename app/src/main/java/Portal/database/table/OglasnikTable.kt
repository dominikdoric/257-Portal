package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class OglasnikTable(

    val oglasnikSlika: Int,

    val oglasnikClanak: String,

    val oglasnikNaslov: String,

    val oglasnikCijena: String,

    val oglasnikLokacija: String,

    val oglasnikBroj: String,

    val oglasnikVrijeme: String
) : Parcelable