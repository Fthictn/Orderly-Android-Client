package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fethicectin.orderly.Model.UserRequest
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Response.UserResponse
import com.fethicectin.orderly.Service.CallRequestCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : Activity() {

    var loginButton:Button? = null
    var userEmail:EditText? = null
    var userPassword:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById<Button>(R.id.login) as Button
        userEmail = findViewById<EditText>(R.id.email) as EditText
        userPassword = findViewById<EditText>(R.id.password) as EditText
    }

    fun loginButtonOnClick(view: View) {

        val req = UserRequest()
        req.email = userEmail?.text.toString()
        req.password = userPassword?.text.toString()
        val call: Call<UserResponse?>? = CallRequestCreator.create().authonticate(req)

        call?.enqueue(object : Callback<UserResponse?> {
            override fun onResponse(call: Call<UserResponse?>?, response: Response<UserResponse?>) {
                if(response.body()!!.statusCode?.trim().equals("OK")) {
                    val projectActivity = Intent(this@LoginActivity, ProjectActivity::class.java)
                    startActivity(projectActivity)
                    val settings = getSharedPreferences("UserInfo", 0)
                    val editor = settings.edit()
                    editor.putString("Username", txtUname.getText().toString())
                    editor.putString("Password", txtPWD.getText().toString())
                    editor.apply()
                }

                val toast = Toast.makeText(
                    applicationContext,
                    response.body()!!.errorMessage,
                    Toast.LENGTH_LONG
                )
                toast.show()
            }

            override fun onFailure(call: Call<UserResponse?>?, t: Throwable) {
                Log.d("FAILURE", t.message.toString())
            }
        })

    }

    fun signUpLink(view: View){
        val mainActivity = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(mainActivity)
    }

 }