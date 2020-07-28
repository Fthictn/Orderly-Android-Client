package com.fethicectin.orderly.Service

import com.fethicectin.orderly.Model.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface APIService {
    @POST("authonticate")
    fun authonticate(@Body req : UserRequest): Call<Boolean?>?
}