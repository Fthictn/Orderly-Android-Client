package com.fethicectin.orderly.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.fethicectin.orderly.Activities.LoginActivity
import com.fethicectin.orderly.Activities.MainActivity
import com.fethicectin.orderly.R

class SignUpFragment : Fragment() {
    var signupButton:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        signupButton = view.findViewById(R.id.signup)

        signupButton?.setOnClickListener {

            val currentActivity = Intent(activity, LoginActivity::class.java)
            startActivity(currentActivity)
        }

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

}