package org.fhmsyhdproject.premiere.view.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.fhmsyhdproject.premiere.R
import org.fhmsyhdproject.premiere.databinding.ActivityHomeBinding
import org.fhmsyhdproject.premiere.utils.adapter.SectionHomeAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionAdapter = SectionHomeAdapter(this, supportFragmentManager)
        binding.viewPager.apply {
            adapter = sectionAdapter
            binding.tabLayout.setupWithViewPager(this)
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_favorite -> {
                    // Handle favorite icon press
//                    startActivity(Intent(this, FavoriteActivity::class.java))
                    val uri = Uri.parse("premiere://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                    true
                }
                else -> false
            }
        }

        supportActionBar?.elevation = 0f
    }
}