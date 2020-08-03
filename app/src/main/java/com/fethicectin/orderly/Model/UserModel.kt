package com.fethicectin.orderly.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel {

    @SerializedName("id")
    @Expose
    var id:Int? = null


    @SerializedName("userNameSurname")
    @Expose
    var nameSurname:String? = null

    @SerializedName("userTitle")
    @Expose
    var projectTitle:String? = null

    @SerializedName("userPassword")
    @Expose
    var password:String? = null

    @SerializedName("userEmail")
    @Expose
    var email:String? = null

    init {
        id = null
        nameSurname = null
        projectTitle = null
        password = null
        email = null
    }
}