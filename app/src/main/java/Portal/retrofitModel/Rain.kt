package Portal.retrofitModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rain (
        @SerializedName("3h")
        @Expose
        private val _3h: Double? = null
        )