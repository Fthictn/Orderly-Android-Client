package com.fethicectin.orderly.Model.Response

import com.fethicectin.orderly.Model.ProjectModel
import com.fethicectin.orderly.Model.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProjectResponse {
    @SerializedName("errorMessage")
    @Expose
    var errorMessage:String? = null

    @SerializedName("statusCode")
    @Expose
    var statusCode:String? = null

    @SerializedName("response")
    @Expose
    var response: List<ProjectModel>? = null;

    @SerializedName("dateTime")
    @Expose
    var dateTime:String? = null

    @SerializedName("userId")
    @Expose
    var userId:Int? = null

    init {
        errorMessage = null
        statusCode = null
        response = null
        dateTime = null
        userId = null
    }
}