package com.fethicectin.orderly.Activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.fethicectin.orderly.Constants.GlobalVars
import com.fethicectin.orderly.Fragments.HomeFragment
import com.fethicectin.orderly.Model.PostModel
import com.fethicectin.orderly.Model.Response.PostResponse
import com.fethicectin.orderly.R
import com.fethicectin.orderly.Service.CallRequestCreator
import com.fethicectin.orderly.Utils.MainTabAdapter
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
   // var postList = listOf<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val postResponse = intent.extras.get("post_response") as PostResponse
       // this.postList = postResponse.response!!

        //this.postList = GlobalVars.posts!!

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.home_page))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.favorite_page))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.profile_page))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MainTabAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    fun sendPostsToFragment(): List<PostModel>? {
        //return this.postList
        return null
    }
}