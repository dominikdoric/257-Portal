package Portal.retrofit.api

import Portal.retrofit.model.PostModel
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): PostModel

}