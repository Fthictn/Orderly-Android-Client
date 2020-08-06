package com.fethicectin.orderly.Utils

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fethicectin.orderly.Fragments.HomeFragment
import com.fethicectin.orderly.Fragments.ProfileFragment
import com.fethicectin.orderly.Fragments.AddQuestionFragment

class MainTabAdapter(private val context: Context, fragmentManager: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return AddQuestionFragment()
            }
            2 -> {
                return ProfileFragment()
            }
            else -> return HomeFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}