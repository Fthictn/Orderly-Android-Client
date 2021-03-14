package com.fethicectin.orderly.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnswerModel {
    @SerializedName("id")
    @Expose
    var id:Int? = null

    @SerializedName("content")
    @Expose
    var content:String? = null

    @SerializedName("createdTime")
    @Expose
    var createdTime:String? = null

    @SerializedName("isCorrect")
    @Expose
    var isCorrect:String? = null

    init {
        id = -1
        content = null
        createdTime = null
        isCorrect = null
    }
}