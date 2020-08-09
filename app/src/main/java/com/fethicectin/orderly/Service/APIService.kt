package com.fethicectin.orderly.Service

import com.fethicectin.orderly.Model.UserModel
import com.fethicectin.orderly.Model.UserRequest
import com.fethicectin.orderly.Response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface APIService {
    @POST("authonticate")
    fun authonticate(@Body req : UserRequest): Call<UserResponse?>?

    @POST("createUser")
    fun createUser(@Body model : UserModel): Call<UserResponse?>?
}