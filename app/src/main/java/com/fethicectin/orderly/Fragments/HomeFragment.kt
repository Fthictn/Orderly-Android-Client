package com.fethicectin.orderly.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.fethicectin.orderly.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val addQuestionButton = view?.findViewById<FloatingActionButton>(R.id.addQuestionButton)

        addQuestionButton?.setOnClickListener {
            tabLayout = activity?.findViewById<TabLayout>(R.id.tabLayout)
            viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)

            tabLayout?.setScrollPosition(1,0f,true)
            viewPager?.setCurrentItem(1);
        }

    }

}