package Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {
    @SerializedName("id")
    @Expose
    var id : Int? = null

    @SerializedName("first_name")
    @Expose
    var firstName : String? = null

    @SerializedName("last_name")
    @Expose
    var lastName : String? = null

    @SerializedName("avatar")
    @Expose
    var avatar : String? = null

    init {
        id = null
        firstName = null
        lastName = null
        avatar = null
    }
}