package Portal.retrofitModel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherList (
        @SerializedName("dt")
        @Expose
        val dt: Int? = null,

        @SerializedName("main")
        @Expose
        val main: Main? = null,

        @SerializedName("weather")
        @Expose
        val weather: List<Weather>? = null,

        @SerializedName("clouds")
        @Expose
        val clouds: Clouds? = null,

        @SerializedName("wind")
        @Expose
        val wind: Wind? = null,

        @SerializedName("sys")
        @Expose
        val sys: Sys? = null,

        @SerializedName("dt_txt")
        @Expose
        val dtTxt: String? = null,

        @SerializedName("rain")
        @Expose
        val rain: Rain? = null
        ): Parcelable {
        constructor(parcel: Parcel) : this() {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<WeatherList> {
                override fun createFromParcel(parcel: Parcel): WeatherList {
                        return WeatherList(parcel)
                }

                override fun newArray(size: Int): Array<WeatherList?> {
                        return arrayOfNulls(size)
                }
        }
        }