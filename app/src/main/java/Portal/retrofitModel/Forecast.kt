package Portal.retrofitModel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "cod")
    val cod: String = "",
    @Json(name = "message")
    val message: Double = 0.0,
    @Json(name = "cnt")
    val cnt: Int = 0,
    @Json(name = "list")
    val list: List<ListEntries> = listOf(),
    @Json(name = "city")
    val city: City = City()
) {
    data class ListEntries(
        @Json(name = "dt")
        val dt: Int = 0,
        @Json(name = "main")
        val main: Main = Main(),
        @Json(name = "weather")
        val weather: List<Weather> = listOf(),
        @Json(name = "clouds")
        val clouds: Clouds = Clouds(),
        @Json(name = "wind")
        val wind: Wind = Wind(),
        @Json(name = "snow")
        val snow: Snow = Snow(),
        @Json(name = "sys")
        val sys: Sys = Sys(),
        @Json(name = "dt_txt")
        val dtTxt: String = ""
    ) {
        val dateTime: String
            get() = dtTxt.toDate().formatTo("dd/MM/yyy HH:mm")

        data class Main(
            @Json(name = "temp")
            val temp: Double? = 0.0,
            @Json(name = "temp_min")
            val tempMin: Double = 0.0,
            @Json(name = "temp_max")
            val tempMax: Double = 0.0,
            @Json(name = "pressure")
            val pressure: Double? = 0.0,
            @Json(name = "sea_level")
            val seaLevel: Double = 0.0,
            @Json(name = "grnd_level")
            val grndLevel: Double = 0.0,
            @Json(name = "humidity")
            val humidity: Int? = 0,
            @Json(name = "temp_kf")
            val tempKf: Double = 0.0
        ) {
            val tempInCelsius: String
                get() = temp?.toCelsius()?.roundToInt().toString()
        }

        data class Weather(
            @Json(name = "id")
            val id: Int = 0,
            @Json(name = "main")
            val main: String = "",
            @Json(name = "description")
            val description: String = "",
            @Json(name = "icon")
            val icon: String = ""
        ) {
            val iconUrl: String
                get() = "https://openweathermap.org/img/wn/$icon@2x.png"
        }

        data class Clouds(
            @Json(name = "all")
            val all: Int = 0
        )

        data class Wind(
            @Json(name = "speed")
            val speed: Double = 0.0,
            @Json(name = "deg")
            val deg: Double = 0.0
        )

        class Snow(
        )

        data class Sys(
            @Json(name = "pod")
            val pod: String = ""
        )
    }

    data class City(
        @Json(name = "id")
        val id: Int = 0,
        @Json(name = "name")
        val name: String = "",
        @Json(name = "coord")
        val coord: Coord = Coord(),
        @Json(name = "country")
        val country: String = ""
    ) {
        data class Coord(
            @Json(name = "lat")
            val lat: Double = 0.0,
            @Json(name = "lon")
            val lon: Double = 0.0
        )
    }
}