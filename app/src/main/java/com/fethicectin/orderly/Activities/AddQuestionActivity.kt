package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import com.fethicectin.orderly.Constants.GlobalVars
import com.fethicectin.orderly.Model.PostModel
import com.fethicectin.orderly.Model.ProjectModel
import com.fethicectin.orderly.Model.Response.PostResponse
import com.fethicectin.orderly.Model.Response.UserResponse
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Service.CallRequestCreator
import kotlinx.android.synthetic.main.activity_add_question.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddQuestionActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
    }

    fun addQuestionOnClick(view: View) {
        val postTitleText = postTitle.text.toString()
        val postContentText = postContent.text.toString()
        val postTypeText = postType.text.toString()
        val postModel = PostModel()
        val projectEntity = ProjectModel()

        projectEntity.id = GlobalVars.projectId
        postModel.postTitle = postTitleText
        postModel.postContent = postContentText
        postModel.type = postTypeText
        postModel.projectEntity = projectEntity

        val call: Call<PostResponse?>? = CallRequestCreator.create().addPost(postModel)

        call?.enqueue(object : Callback<PostResponse?> {
            override fun onResponse(call: Call<PostResponse?>?, response: Response<PostResponse?>) {
                if(response.body()?.statusCode?.trim().equals("OK")) {
                    GlobalVars.posts = response.body()!!.response
                    val mainActivity = Intent(this@AddQuestionActivity, MainActivity::class.java)
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


    }
    fun cancelOnClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}