package Portal.retrofit.repository

import Portal.retrofit.api.RetrofitInstance
import Portal.retrofit.model.WeatherModel

class Repository {

    suspend fun getWeather(): WeatherModel{
       return RetrofitInstance.api.getWeather()
    }

}