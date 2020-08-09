package com.fethicectin.orderly.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.fethicectin.orderly.Activities.AddQuestionActivity
import com.fethicectin.orderly.Activities.MainActivity
import com.fethicectin.orderly.Activities.SignupActivity
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Utils.QuestionRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
  //  var tabLayout: TabLayout? = null
  //  var viewPager: ViewPager? = null
    var titles = mutableListOf<String>()
    var contents = mutableListOf<String>()
    var questionId = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val addQuestionButton = view?.findViewById<FloatingActionButton>(R.id.addQuestionButton)

        addQuestionButton?.setOnClickListener {
            // tabLayout = activity?.findViewById<TabLayout>(R.id.tabLayout)
            // viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)
            // tabLayout?.setScrollPosition(1,0f,true)
            // viewPager?.setCurrentItem(1);
            val addQuestionActivity = Intent(activity, AddQuestionActivity::class.java)
            startActivity(addQuestionActivity)
        }

        for (i in 0..35){
            titles.add(i, "Soru başlığı")
            contents.add(i, "Soru içeriğidir. Uzaması için bazı hamleler yapılmıştır.Lütfen dikkate almayınız")
            questionId = 1
        }

        questionRecyclerView.layoutManager = LinearLayoutManager(context)
        questionRecyclerView.adapter = QuestionRecyclerAdapter(titles,contents,questionId)

    }

}