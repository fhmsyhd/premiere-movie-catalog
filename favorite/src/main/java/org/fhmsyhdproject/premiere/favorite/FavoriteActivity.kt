package org.fhmsyhdproject.premiere.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.fhmsyhdproject.premiere.favorite.databinding.ActivityFavoriteBinding
import org.fhmsyhdproject.premiere.favorite.adapter.SectionFavoriteAdapter
import org.fhmsyhdproject.premiere.favorite.di.favoriteModule
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val sectionAdapter = SectionFavoriteAdapter(this, supportFragmentManager)
        binding.viewPager.apply {
            adapter = sectionAdapter
            binding.tabLayout.setupWithViewPager(this)
        }

        binding.topAppBar.setNavigationOnClickListener { finish() }

        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}