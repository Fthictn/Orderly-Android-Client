package com.fethicectin.orderly.Model.Response

import android.os.Parcelable
import com.fethicectin.orderly.Model.PostModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PostResponse :Serializable {
    @SerializedName("errorMessage")
    @Expose
    var errorMessage:String? = null

    @SerializedName("statusCode")
    @Expose
    var statusCode:String? = null

    @SerializedName("response")
    @Expose
    var response: List<PostModel>? = null;

    @SerializedName("dateTime")
    @Expose
    var dateTime:String? = null

    @SerializedName("projectId")
    @Expose
    var projectId:Int? = null

    init {
        errorMessage = null
        statusCode = null
        response = null
        dateTime = null
        projectId = null
    }
}