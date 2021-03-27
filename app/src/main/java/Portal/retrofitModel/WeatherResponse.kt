package Portal.retrofitModel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
        @SerializedName("cod")
        @Expose
        val cod: String? = null,

        @SerializedName("message")
        @Expose
        val message: Int? = null,

        @SerializedName("cnt")
        @Expose
        val cnt: Int? = null,

        @SerializedName("list")
        @Expose
        var list: List<WeatherList>? = null,

        @SerializedName("city")
        @Expose
        val city: City? = null
) : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cod)
        parcel.writeValue(message)
        parcel.writeValue(cnt)
        parcel.writeList(list)
        parcel.writeValue(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherResponse> {
        override fun createFromParcel(parcel: Parcel): WeatherResponse {
            return WeatherResponse(parcel)
        }

        override fun newArray(size: Int): Array<WeatherResponse?> {
            return arrayOfNulls(size)
        }
    }
}