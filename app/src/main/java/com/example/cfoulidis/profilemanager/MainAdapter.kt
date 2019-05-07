package com.example.cfoulidis.profilemanager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


/**
 * Created by cfoulidis on 4/22/2019.
 */
class MainAdapter(fragmentmanager: FragmentManager): FragmentPagerAdapter(fragmentmanager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                return ThirdFragment()
            }
        }
    }



    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
    }

}

}