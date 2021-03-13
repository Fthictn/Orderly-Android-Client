package com.fethicectin.orderly.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProjectModel:Serializable {
    @SerializedName("id")
    @Expose
    var id:Int? = null

    @SerializedName("projectName")
    @Expose
    var projectName:String? = null

    @SerializedName("projectCode")
    @Expose
    var projectCode:String? = null

    init {
        id = -1
        projectCode = null
        projectName = null
    }

}