package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PoljoprivredaTable(
    val poljoprivredaNaslov: String = "",
    val poljoprivredaClanak: String = ""
) : Parcelable