package com.imnstudios.sendbro.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.imnstudios.sendbro.R
import com.imnstudios.sendbro.databinding.ActivityHomeBinding
import com.imnstudios.sendbro.ui.adapters.ViewPager2Adapter
import com.imnstudios.sendbro.util.SendBroApplication.Companion.applicationContext
import com.imnstudios.sendbro.util.logger


class HomeActivity : AppCompatActivity() {

    companion object {
        val fragmentTitles =
            listOf(applicationContext().getString(R.string.images), applicationContext().getString(R.string.videos))
        val fragmentIcons =
            listOf(
                ContextCompat.getDrawable(
                    applicationContext(),
                    R.drawable.ic_baseline_image_24
                ),
                ContextCompat.getDrawable(applicationContext(), R.drawable.ic_baseline_video_library_24)
            )
    }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager()

    }

    private fun setUpViewPager() {
        binding.pager.adapter = ViewPager2Adapter(this)
        binding.tabLayout.apply {
            TabLayoutMediator(
                this, binding.pager
            ) { tab: TabLayout.Tab, position: Int ->
                tab.icon = fragmentIcons[position]
            }.attach()

            binding.toolbarTitle.text = fragmentTitles[0]
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.toolbarTitle.text = when (tab?.position) {
                        0 -> fragmentTitles[0]
                        1 -> fragmentTitles[1]
                        else -> fragmentTitles[0]
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {/*NO-OP*/
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {/*NO-OP*/
                }

            })
        }
        "Setting up ViewPager: success".logger()
    }
}