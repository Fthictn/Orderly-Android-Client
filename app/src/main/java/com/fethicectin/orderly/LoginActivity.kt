package com.fethicectin.orderly

import Model.Datum
import Model.VeriListem
import Service.APIService
import Service.APIUrl
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {
    lateinit var service:APIService
    var dat:List<Datum>? = null
    var loginButton:Button? = null
    var userEmail:EditText? = null
    var userPassword:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById<Button>(R.id.login) as Button
        userEmail = findViewById<EditText>(R.id.email) as EditText
        userPassword = findViewById<EditText>(R.id.password) as EditText
        gam()
        LoginOnclick(loginButton)
    }

    fun LoginOnclick(loginButton : Button?){
        loginButton?.setOnClickListener {
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }
    }

    fun gam(){
        val gson = GsonBuilder().setLenient().create()

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        val apis = retrofit.create(APIService::class.java)
        val call: Call<VeriListem?>? = apis.verilerimilistele(1)
        call?.enqueue(object : Callback<VeriListem?> {
            override fun onResponse(
                call: Call<VeriListem?>?,
                response: Response<VeriListem?>
            ) {
                val body = response.body()
                dat = (if (body != null) body.getEmployee() else null)!!
                Log.d("SNOW", response.raw().request().url().toString())
                Log.d("SNOW", dat?.get(0)?.firstName.toString())
                Log.d("SNOW", response.body()?.totalPage.toString())


            }

            override fun onFailure(call: Call<VeriListem?>?, t: Throwable) {
                Log.d("snow", t.message.toString())
            }
        })
    }

}