package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ZabavaTable(

    val zabavaNaslov: String = "",

    val zabavaClanak: String = ""
) : Parcelable