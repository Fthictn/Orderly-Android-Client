package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fethicectin.orderly.R

class ProjectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
    }

    fun createButtonOnClick(view: View) {
        val addQuestionActivity = Intent(this@ProjectActivity, CreateNewProjectActivity::class.java)
        startActivity(addQuestionActivity)
    }
    fun enterButtonOnClick(view: View) {
        val mainActivity = Intent(this@ProjectActivity, MainActivity::class.java)
        startActivity(mainActivity)
    }
}