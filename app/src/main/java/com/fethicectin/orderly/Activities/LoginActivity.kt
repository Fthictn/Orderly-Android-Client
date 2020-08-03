package com.fethicectin.orderly.Activities

import com.fethicectin.orderly.Constants.Messages
import com.fethicectin.orderly.Model.UserRequest
import com.fethicectin.orderly.Service.CallRequestCreator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fethicectin.orderly.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class LoginActivity : AppCompatActivity() {

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
        val call: Call<Boolean?>? = CallRequestCreator.create().authonticate(req)

        call?.enqueue(object : Callback<Boolean?> {
            override fun onResponse(call: Call<Boolean?>?, response: Response<Boolean?>) {
                var toastText:String = ""
                if(response.body()!!) {
                    toastText = Messages.loginSuccessMessage
                    val mainActivity = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(mainActivity)
                }else{
                    toastText = Messages.loginFailMessage
                }

                val toast = Toast.makeText(
                    applicationContext,
                    toastText,
                    Toast.LENGTH_LONG
                )
                toast.show()
            }
            override fun onFailure(call: Call<Boolean?>?, t: Throwable) {
                Log.d("FAILURE", t.message.toString())
            }
        })

    }

    fun signUpLink(view: View){
        val mainActivity = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(mainActivity)
    }

 }