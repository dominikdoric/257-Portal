package Portal.model

import android.os.Parcel
import android.os.Parcelable

data class SportTable(
    var naslov: String? = "",
    var clanak: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(naslov)
        parcel.writeString(clanak)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SportTable> {
        override fun createFromParcel(parcel: Parcel): SportTable {
            return SportTable(parcel)
        }

        override fun newArray(size: Int): Array<SportTable?> {
            return arrayOfNulls(size)
        }
    }
}