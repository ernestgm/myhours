package com.ernestgm.myhours.ui.slides.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ernestgm.myhours.ui.slides.SlidesItemsFragment

class SlidesAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = SlidesItemsFragment()
}