package com.fethicectin.orderly.Model.Response

import com.fethicectin.orderly.Model.AnswerModel
import com.fethicectin.orderly.Model.PostModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnswerResponse {
    @SerializedName("errorMessage")
    @Expose
    var errorMessage:String? = null

    @SerializedName("statusCode")
    @Expose
    var statusCode:String? = null

    @SerializedName("response")
    @Expose
    var response: List<AnswerModel>? = null;

    @SerializedName("dateTime")
    @Expose
    var dateTime:String? = null

    @SerializedName("postId")
    @Expose
    var postId:Int? = null

    init {
        errorMessage = null
        statusCode = null
        response = null
        dateTime = null
        postId = null
    }
}