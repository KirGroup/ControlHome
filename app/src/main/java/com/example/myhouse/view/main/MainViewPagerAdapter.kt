package com.example.myhouse.view.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myhouse.view.cameras.CamerasFragment
import com.example.myhouse.view.doors.DoorsFragment

class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                CamerasFragment()
            }
            1 -> {
                DoorsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}