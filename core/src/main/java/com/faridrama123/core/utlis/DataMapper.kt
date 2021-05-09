package com.faridrama123.core.utlis

import com.faridrama123.core.data.source.local.entity.TeamEntity
import com.faridrama123.core.data.source.remote.response.TeamsResponse
import com.faridrama123.core.domain.model.Teams


object DataMapper {
    fun mapResponsesToEntities(input: List<TeamsResponse>): List<TeamEntity> {
        val teamList = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLeague = it.strLeague,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strWebsite = it.strWebsite,
                strFacebook = it.strFacebook,
                strTwitter = it.strTwitter,
                strInstagram = it.strInstagram,
                strDescriptionEN = it.strDescriptionEN,
                strTeamBadge = it.strTeamBadge,
                isFavorite = false
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Teams> =
        input.map {
            Teams(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLeague = it.strLeague,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strWebsite = it.strWebsite,
                strFacebook = it.strFacebook,
                strTwitter = it.strTwitter,
                strInstagram = it.strInstagram,
                strDescriptionEN = it.strDescriptionEN,
                    strTeamBadge = it.strTeamBadge,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(it: Teams) = TeamEntity(
        idTeam = it.idTeam,
        strTeam = it.strTeam,
        strLeague = it.strLeague,
        strStadium = it.strStadium,
        strStadiumThumb = it.strStadiumThumb,
        strWebsite = it.strWebsite,
        strFacebook = it.strFacebook,
        strTwitter = it.strTwitter,
        strInstagram = it.strInstagram,
        strDescriptionEN = it.strDescriptionEN,
            strTeamBadge = it.strTeamBadge,
        isFavorite = it.isFavorite
    )
}