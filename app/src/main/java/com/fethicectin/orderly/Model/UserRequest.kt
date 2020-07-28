package com.fethicectin.orderly.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("email")
    @Expose
    var email:String? = null

    @SerializedName("password")
    @Expose
    var password:String? = null

    init {
        email = null
        password = null
    }

}