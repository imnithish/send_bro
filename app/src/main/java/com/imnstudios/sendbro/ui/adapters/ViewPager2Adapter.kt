package com.imnstudios.sendbro.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.imnstudios.sendbro.ui.activities.HomeActivity.Companion.fragmentTitles
import com.imnstudios.sendbro.ui.fragments.ImagesFragment
import com.imnstudios.sendbro.ui.fragments.VideosFragment

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragmentTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ImagesFragment()
            1 -> VideosFragment()
            else -> ImagesFragment()
        }
    }
}