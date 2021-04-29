package Portal.firestore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = -1
        ): Parcelable