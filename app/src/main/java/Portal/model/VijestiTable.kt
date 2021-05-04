package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VijestiTable(

    val vijestiNaslov: String = "",

    val vijestiClanak: String = ""
) : Parcelable