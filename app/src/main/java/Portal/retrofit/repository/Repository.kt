package Portal.retrofit.repository

import Portal.retrofit.api.RetrofitInstance
import Portal.retrofit.model.PostModel

class Repository {

    suspend fun getPost(): PostModel{
        return RetrofitInstance.api.getPost()
    }

}