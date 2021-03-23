package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "info")
data class InfoTable (

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "ime")
    val ime: String,

    @ColumnInfo(name = "prezime")
    val prezime: String

    ): Parcelable