package com.fethicectin.orderly.Response

import com.fethicectin.orderly.Model.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

class UserResponse {
    @SerializedName("errorMessage")
    @Expose
    var errorMessage:String? = null

    @SerializedName("statusCode")
    @Expose
    var statusCode:String? = null

    @SerializedName("response")
    @Expose
    var response: UserModel? = null;

    @SerializedName("dateTime")
    @Expose
    var dateTime:String? = null

    init {
        errorMessage = null
        statusCode = null
        response = null
        dateTime = null
    }
}