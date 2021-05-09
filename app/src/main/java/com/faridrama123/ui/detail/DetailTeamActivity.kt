package com.faridrama123.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.faridrama123.R
import com.faridrama123.core.domain.model.Teams
import com.faridrama123.databinding.ActivityDetailTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTeamActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailTeamBinding
    private val detailTeamViewModel : DetailTeamViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTeam = intent.getParcelableExtra<Teams>(EXTRA_DATA)
        showDetailTeam(detailTeam)

    }

    private fun showDetailTeam(detailTeam: Teams?) {
        detailTeam?.let {
            supportActionBar?.title = detailTeam.strTeam
            with(binding){
                league.text =  resources.getString(R.string.text_league, detailTeam.strLeague.toString() )
                stadium.text = resources.getString(R.string.text_stadium, detailTeam.strStadium.toString() )
                website.text = resources.getString(R.string.text_website, detailTeam.strWebsite.toString() )
                content.tvDetailDescription.text = detailTeam.strDescriptionEN
                Glide.with(this@DetailTeamActivity)
                        .load(detailTeam.strTeamBadge)
                        .into(ivDetailImage)

                Glide.with(this@DetailTeamActivity)
                        .load(detailTeam.strStadiumThumb)
                        .into(ivDetailPoster)

                var statusFavorite = detailTeam.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailTeamViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }


            }


        }
    }
    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}