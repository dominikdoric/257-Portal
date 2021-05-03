package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OglasnikTable(

    val oglasnikClanak: String,

    val oglasnikNaslov: String,

    val oglasnikCijena: String,

    val oglasnikLokacija: String,

    val oglasnikBroj: String,

    val oglasnikVrijeme: String
) : Parcelable