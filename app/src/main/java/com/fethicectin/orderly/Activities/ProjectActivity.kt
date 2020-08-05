package com.fethicectin.orderly.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fethicectin.orderly.R

class ProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
    }

    fun createButtonOnClick(view: View) {}
    fun enterButtonOnClick(view: View) {
        val mainActivity = Intent(this@ProjectActivity, MainActivity::class.java)
        startActivity(mainActivity)
    }
}