package com.faridrama123.core.data.source.local.room

import androidx.room.*
import com.faridrama123.core.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getAllTeam(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team where isFavorite = 1")
    fun getFavoriteTeam(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(tourism: List<TeamEntity>)

    @Update
    fun updateFavoriteTeam(tourism: TeamEntity)
}