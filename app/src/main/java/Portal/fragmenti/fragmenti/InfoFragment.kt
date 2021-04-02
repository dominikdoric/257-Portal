package Portal.fragmenti.fragmenti

import Portal.a257.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment(R.layout.info_fragment) {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"

    fun creatiNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

}


