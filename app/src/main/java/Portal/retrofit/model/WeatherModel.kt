package Portal.retrofit.model

import com.google.gson.annotations.SerializedName


data class WeatherModel(
    @SerializedName("base")
    val base: Int,

    @SerializedName("visibility")
    val visibility: Long,

    @SerializedName("dt")
    val dt: Long,

    @SerializedName("timezone")
    val timezone: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("cod")
    val cod: Int
) {

}