package com.faridrama123.core.data.source.remote.network
import com.faridrama123.core.data.source.remote.response.ListTeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search_all_teams.php")
    suspend fun getListTeam(
        @Query("l") league: String
    ): ListTeamsResponse
}
