package Portal.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "oglasnik")
data class OglasnikTable (

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "oglasnik_slika")
    val oglasnikSlika: Int,

    @ColumnInfo(name = "oglasnik_clanak")
    val oglasnikClanak: String,

    @ColumnInfo(name = "oglasnik_naslov")
    val oglasnikNaslov: String,

    @ColumnInfo(name = "oglasnik_cijena")
    val oglasnikCijena: String,

    @ColumnInfo(name = "oglasnik_lokacija")
    val oglasnikLokacija: String,

    @ColumnInfo(name = "oglasnik_broj")
    val oglasnikBroj: String,

    @ColumnInfo(name = "oglasnik_vrijeme")
    val oglasnikVrijeme: String
        ): Parcelable