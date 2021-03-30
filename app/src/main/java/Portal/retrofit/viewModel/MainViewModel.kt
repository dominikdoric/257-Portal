package Portal.retrofit.viewModel

import Portal.retrofit.model.WeatherModel
import Portal.retrofit.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
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