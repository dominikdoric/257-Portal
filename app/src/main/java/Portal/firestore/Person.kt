package Portal.firestore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    var naslov: String = "",
    var clanak: String = "",
    var vrijeme: String = ""
        ): Parcelable