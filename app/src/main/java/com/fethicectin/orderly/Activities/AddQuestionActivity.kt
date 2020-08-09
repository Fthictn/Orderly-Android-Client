package com.fethicectin.orderly.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.fethicectin.orderly.R


class AddQuestionActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
    }

    fun addQuestionOnClick(view: View) {}
    fun cancelOnClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}