package com.fethicectin.orderly.Service

import com.fethicectin.orderly.Model.PostModel
import com.fethicectin.orderly.Model.ProjectModel
import com.fethicectin.orderly.Model.Response.PostResponse
import com.fethicectin.orderly.Model.Response.ProjectResponse
import com.fethicectin.orderly.Model.UserModel
import com.fethicectin.orderly.Model.UserRequest
import com.fethicectin.orderly.Model.Response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface APIService {
    @POST("authonticate")
    fun authonticate(@Body req : UserRequest): Call<UserResponse?>?

    @POST("createUser")
    fun createUser(@Body model : UserModel): Call<UserResponse?>?

    @GET("projects/{projectCode}")
    fun getPostByProjectCode(@Path("projectCode") projectCode:String): Call<PostResponse?>?

    @POST("createProject")
    fun createProject(@Body request:ProjectModel) : Call<ProjectResponse?>?

    @POST("createPost")
    fun addPost(@Body request:PostModel): Call<PostResponse?>?
}