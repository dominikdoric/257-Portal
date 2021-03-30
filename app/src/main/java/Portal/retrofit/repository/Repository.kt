package Portal.retrofit.repository

import Portal.retrofit.api.RetrofitInstance
import Portal.retrofit.model.WeatherModel
import retrofit2.Retrofit
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: RetrofitInstance,
    private val Retrofit: Retrofit
) {

    suspend fun getWeather(): WeatherModel {
        return retrofit.provideApi().getWeather()
    }

}