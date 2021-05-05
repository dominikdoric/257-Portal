package Portal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokusTable(
    val ime: String,
    val prezime: String
) : Parcelable