package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ObavijestiTable(

    val obavijestiNaslov: String = "",
    val obavijestiClanak: String = "",
    val obavijestiVrijeme: String = ""

) : Parcelable