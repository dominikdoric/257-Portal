package Portal.firestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SportModel (
    val sportNaslov: String = "",
    val sportClanak: String = "",
    val sportVrijeme: String = "",
    val sportSlika: Int = -1
        ): Parcelable