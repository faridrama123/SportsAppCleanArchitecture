package com.faridrama123.core.data.source.local


import com.faridrama123.core.data.source.local.entity.TeamEntity
import com.faridrama123.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val teamDao: TeamDao) {

    fun getAllTeam(): Flow<List<TeamEntity>> = teamDao.getAllTeam()

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamEntity, newState: Boolean) {
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}