package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.fethicectin.orderly.Constants.GlobalVars
import com.fethicectin.orderly.Constants.Messages
import com.fethicectin.orderly.Model.Response.PostResponse
import com.fethicectin.orderly.Model.Response.UserResponse
import com.fethicectin.orderly.Model.UserRequest
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Service.CallRequestCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectActivity : Activity() {
    var projectCode:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
        projectCode = findViewById(R.id.projectcode)
    }

    fun createButtonOnClick(view: View) {
        val addQuestionActivity = Intent(this@ProjectActivity, CreateNewProjectActivity::class.java)
        startActivity(addQuestionActivity)
    }
    fun enterButtonOnClick(view: View) {

        var projectCodeText = projectCode?.text.toString()

        if(!projectCodeText.isEmpty()) {
            val call: Call<PostResponse?>? = CallRequestCreator.create().getPostByProjectCode(projectCodeText)

            call?.enqueue(object : Callback<PostResponse?> {
                override fun onResponse(call: Call<PostResponse?>?, response: Response<PostResponse?>) {
                    if(response.body()!!.statusCode?.trim().equals("OK")) {
                        GlobalVars.projectId = response.body()!!.response?.get(0)?.projectEntity?.id
                        val mainActivity = Intent(this@ProjectActivity, MainActivity::class.java)
                        mainActivity.putExtra("post_response", response.body())
                        startActivity(mainActivity)
                    }

                    val toast = Toast.makeText(
                        applicationContext,
                        response.body()!!.errorMessage,
                        Toast.LENGTH_LONG
                    )
                    toast.show()
                }

                override fun onFailure(call: Call<PostResponse?>?, t: Throwable) {
                    Log.d("FAILURE", t.message.toString())
                }
            })
        }else{
            val toast = Toast.makeText(
                applicationContext,
               Messages.projectTextEmpty,
                Toast.LENGTH_LONG
            )
            toast.show()
        }

    }
}