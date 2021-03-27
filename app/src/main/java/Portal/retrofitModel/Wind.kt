package Portal.retrofitModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind (
        @SerializedName("speed")
        @Expose
        val speed: Double? = null,

        @SerializedName("deg")
        @Expose
        val deg: Int? = null
        )