package com.faridrama123.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Teams(

   val idTeam : String,
   val strTeam : String,
   val strLeague : String,
   val strStadium : String,
   val strStadiumThumb : String,
   val strWebsite : String,
   val strFacebook : String,
   val strTwitter : String,
   val strInstagram : String,
   val strDescriptionEN : String,
   val strTeamBadge: String,
   val isFavorite: Boolean


):Parcelable