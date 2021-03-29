package Portal.retrofit.viewModel

import Portal.retrofit.model.PostModel
import Portal.retrofit.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<PostModel> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response: PostModel = repository.getPost()
            myResponse.value = response
        }
    }

}