package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fethicectin.orderly.R

class CreateNewProjectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)
    }

    fun createProjectOnClick(view: View) {}
    fun cancelProjectOnClick(view: View) {
        val intent = Intent(this, ProjectActivity::class.java)
        startActivity(intent)
        finish()
    }
}