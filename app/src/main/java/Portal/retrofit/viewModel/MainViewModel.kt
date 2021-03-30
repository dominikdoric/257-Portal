package Portal.retrofit.viewModel

import Portal.retrofit.model.WeatherModel
import Portal.retrofit.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
): ViewModel() {

    val myResponse: MutableLiveData<WeatherModel> = MutableLiveData()

    fun getWeather(){
        viewModelScope.launch {
            val response = repository.getWeather()
            myResponse.value = response
        }
    }

}