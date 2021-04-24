package Portal.firestore

import Portal.a257.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_push.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val TOPIC = "/topics/myTopic"

class PushActivity : AppCompatActivity() {

    val TAG = "PushActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push)

        btnSend.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()
            if (title.isNotEmpty() && message.isNotEmpty()){
                RetrofitPushNotificationData(
                    RetrofitNotificationData(title,message),
                    TOPIC
                ).also {
                    sendNotification(it)
                }
            }
        }
    }

    private fun sendNotification(notification: RetrofitPushNotificationData) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstace.api.postNotification(notification)
                if (response.isSuccessful){
                    Log.d(TAG,"Response: ${Gson().toJson(response)}")
                }else{
                    Log.e(TAG,response.errorBody().toString())
                }
            } catch (e: Exception) {
                Log.e(TAG,e.toString())
            }
        }

}