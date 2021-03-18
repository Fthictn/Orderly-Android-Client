package com.fethicectin.orderly.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Activities.AddQuestionActivity
import com.fethicectin.orderly.Activities.MainActivity
import com.fethicectin.orderly.Constants.GlobalVars
import com.fethicectin.orderly.Utils.QuestionRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val addQuestionButton = view?.findViewById<FloatingActionButton>(R.id.addQuestionButton)
        val mainActivity = activity as MainActivity
        //val postList = mainActivity.sendPostsToFragment()

        addQuestionButton?.setOnClickListener {
            val addQuestionActivity = Intent(activity, AddQuestionActivity::class.java)
            startActivity(addQuestionActivity)
        }

        questionRecyclerView.layoutManager = LinearLayoutManager(context)
        questionRecyclerView.adapter = QuestionRecyclerAdapter(GlobalVars.posts)

    }

}