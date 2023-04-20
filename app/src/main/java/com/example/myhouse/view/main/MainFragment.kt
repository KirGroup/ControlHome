package com.example.myhouse.view.main

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.myhouse.databinding.MainFragmentBinding
import com.example.myhouse.utils.ViewBindingFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : ViewBindingFragment<MainFragmentBinding>(MainFragmentBinding::inflate) {

    private lateinit var viewPagerAdapter: MainViewPagerAdapter
    private lateinit var viewPager2: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPagerAdapter = MainViewPagerAdapter(this)
        viewPager2 = binding.viewPager
        viewPager2.adapter = viewPagerAdapter
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Камеры"
                }
                1 -> {
                    tab.text = "Двери"
                }
            }
        }.attach()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}