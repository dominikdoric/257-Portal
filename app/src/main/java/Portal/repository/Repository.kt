package Portal.repository

import Portal.api.RetrofitInstance
import Portal.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }

}