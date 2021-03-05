package Portal.repository

import Portal.api.RetrofitInstance
import Portal.model.Post
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Post{
        return RetrofitInstance.api.getPost()
    }

}