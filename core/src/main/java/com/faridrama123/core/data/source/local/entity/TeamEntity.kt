package com.faridrama123.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam : String,

    @ColumnInfo(name = "strTeam")
    var strTeam : String,

    @ColumnInfo(name = "strLeague")
    var strLeague : String,

    @ColumnInfo(name = "strStadium")
    var strStadium : String,

    @ColumnInfo(name = "strStadiumThumb")
    var strStadiumThumb : String,

    @ColumnInfo(name = "strWebsite")
    var strWebsite : String,

    @ColumnInfo(name = "strFacebook")
    var strFacebook : String,

    @ColumnInfo(name = "strTwitter")
    var strTwitter : String,

    @ColumnInfo(name = "strInstagram")
    var strInstagram : String,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN : String,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean
)