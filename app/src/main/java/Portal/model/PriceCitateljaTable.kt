package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceCitateljaTable(

    val priceCitateljaNaslov: String = "",

    val priceCitateljaClanak: String = ""
) : Parcelable