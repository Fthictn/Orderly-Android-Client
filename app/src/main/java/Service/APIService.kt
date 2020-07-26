package Service

import Model.VeriListem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {
    @GET("api/users")
    fun verilerimilistele(@Query("page") deger: Int): Call<VeriListem?>?
}