package com.fethicectin.orderly.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PostModel :Serializable{
    @SerializedName("id")
    @Expose
    var id:Int? = null

    @SerializedName("postTitle")
    @Expose
    var postTitle:String? = null

    @SerializedName("postContent")
    @Expose
    var postContent:String? = null

    @SerializedName("createdTime")
    @Expose
    var createdTime:String? = null

    @SerializedName("isSolved")
    @Expose
    var isSolved:String? = null

    @SerializedName("type")
    @Expose
    var type:String? = null

    init {
        id = -1
        postTitle = null
        postContent = null
        createdTime = null
        isSolved
        type
    }
}