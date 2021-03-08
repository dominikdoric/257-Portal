package Portal.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "obavijesti")
data class ObavijestiTable (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "obavijesti_naslov")
    val obavijestiNaslov: String,

    @ColumnInfo(name = "obavijesti_clanak")
    val obavijestiClanak: String,

    @ColumnInfo(name = "obavijesti_vrijeme")
    val obavijestiVrijeme: String,

    @ColumnInfo(name = "obavijesti_slika")
    val obavijestiSlika: Int

        )