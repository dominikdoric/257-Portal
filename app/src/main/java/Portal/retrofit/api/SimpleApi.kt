package Portal.retrofit.api

import Portal.retrofit.model.WeatherModel
import retrofit2.http.GET

interface SimpleApi {

    @GET("weather")
    suspend fun getWeather(): WeatherModel
}