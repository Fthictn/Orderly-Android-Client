package com.fethicectin.orderly.Service

import com.fethicectin.orderly.Constants.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallRequestCreator {

    companion object {
        fun create():APIService{
            val gson = GsonBuilder().setLenient().create()
            val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
            val apiCall = retrofit.create(APIService::class.java)
            return apiCall
        }
    }
}