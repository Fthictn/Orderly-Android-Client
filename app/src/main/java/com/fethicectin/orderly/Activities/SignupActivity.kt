package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.fethicectin.orderly.Model.UserModel
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Service.CallRequestCreator
import com.fethicectin.orderly.Model.Response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun signUpOnclick(view: View) {
        val parentLayout = findViewById<LinearLayout>(R.id.signupParent)
        val namesurname = parentLayout.findViewById<EditText>(R.id.signupNameSurname)
        val projectTitle = parentLayout.findViewById<EditText>(R.id.signupProjectTitle)
        val email = parentLayout.findViewById<EditText>(R.id.signupEmail)
        val password = parentLayout.findViewById<EditText>(R.id.signUpPassword)
        val secondPassword = parentLayout.findViewById<EditText>(R.id.signUpSecondPassword)

        val userModel = UserModel()

        userModel.email = email.text.toString()
        userModel.nameSurname = namesurname.text.toString()
        userModel.projectTitle = projectTitle.text.toString()
        userModel.password = password.text.toString()

        val call: Call<UserResponse?>? = CallRequestCreator.create().createUser(userModel)

            call?.enqueue(object : Callback<UserResponse?> {
                override fun onResponse(call: Call<UserResponse?>?, response: Response<UserResponse?>) {
                    if(response.body()?.statusCode?.trim().equals("OK")) {
                        val loginActivity = Intent(this@SignupActivity, LoginActivity::class.java)
                        startActivity(loginActivity)
                    }
                    Toast.makeText(
                        applicationContext,
                        response.body()?.errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                override fun onFailure(call: Call<UserResponse?>?, t: Throwable) {
                    Log.d("FAILURE", t.message.toString())
                }
            })


    }
}