package Portal.firestore

import Portal.firestore.Constants.Companion.CONTENT_TYPE
import Portal.firestore.Constants.Companion.SERVER_KEY
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitNotificationApi {

    @Headers("Authorization: key=$SERVER_KEY","Content-Type: $CONTENT_TYPE")
    @POST("fcm/send")
    suspend fun postNotification(
        @Body notification: RetrofitPushNotificationData
    ): Response<ResponseBody>
}