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
    val cod: Int,

    @SerializedName("coord")
    val coord: Coord,

    @SerializedName("weather")
    val weather: Weather,

    @SerializedName("main")
    val main: Main,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("sys")
    val sys: Sys
) {

    data class Coord(

        @SerializedName("lon")
        val lon: Double,

        @SerializedName("lat")
        val lat: Double
    )

    data class Weather(

        @SerializedName("id")
        val id: Int,

        @SerializedName("main")
        val main: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("icon")
        val icon: String
    )

    data class Main(

        @SerializedName("temp")
        val temp: Double,

        @SerializedName("feels_like")
        val feelsLike: Double,

        @SerializedName("temp_min")
        val tempMin: Double,

        @SerializedName("temp_max")
        val tempMax: Double,

        @SerializedName("pressure")
        val pressure: Int,

        @SerializedName("humidity")
        val humidity: Int
    )

    data class Wind(

        @SerializedName("speed")
        val speed: Double,

        @SerializedName("deg")
        val deg: Int,

        @SerializedName("gust")
        val gust: Double
    )

    data class Sys(

        @SerializedName("type")
        val type: Int,

        @SerializedName("id")
        val id: Long,

        @SerializedName("country")
        val country: String,

        @SerializedName("sunrise")
        val sunrise: Long,

        @SerializedName("sunset")
        val sunset: Long
    )

    data class Clouds(

        @SerializedName("all")
        val all: Int

    )

}