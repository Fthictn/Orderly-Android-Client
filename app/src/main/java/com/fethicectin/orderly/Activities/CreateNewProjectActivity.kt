package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.fethicectin.orderly.Model.ProjectModel
import com.fethicectin.orderly.Model.Response.ProjectResponse
import com.fethicectin.orderly.Model.Response.UserResponse
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Service.CallRequestCreator
import kotlinx.android.synthetic.main.activity_create_new_project.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateNewProjectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)
    }

    fun createProjectOnClick(view: View) {

        val projectRequest = ProjectModel()
        projectRequest.projectName = projectName.text.toString()
        projectRequest.projectCode = projectCode.text.toString()

        val call: Call<ProjectResponse?>? = CallRequestCreator.create().createProject(projectRequest)

        call?.enqueue(object : Callback<ProjectResponse?> {
            override fun onResponse(call: Call<ProjectResponse?>?, response: Response<ProjectResponse?>) {
                if(response.body()!!.statusCode?.trim().equals("OK")) {
                    val projectActivity = Intent(this@CreateNewProjectActivity, ProjectActivity::class.java)
                    startActivity(projectActivity)
                }

                val toast = Toast.makeText(
                    applicationContext,
                    response.body()!!.errorMessage,
                    Toast.LENGTH_LONG
                )
                toast.show()
            }

            override fun onFailure(call: Call<ProjectResponse?>?, t: Throwable) {
                Log.d("FAILURE", t.message.toString())
            }
        })

    }
    fun cancelProjectOnClick(view: View) {
        val intent = Intent(this, ProjectActivity::class.java)
        startActivity(intent)
        finish()
    }
}