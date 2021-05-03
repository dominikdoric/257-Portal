package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SportTable(
    var naslov: String = "",
    var clanak: String = "",
    var vrijeme: String = ""
): Parcelable