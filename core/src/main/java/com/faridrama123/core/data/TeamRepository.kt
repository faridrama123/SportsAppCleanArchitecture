package com.faridrama123.core.data


import com.faridrama123.core.data.source.local.LocalDataSource
import com.faridrama123.core.data.source.remote.RemoteDataSource
import com.faridrama123.core.data.source.remote.network.ApiResponse
import com.faridrama123.core.data.source.remote.response.TeamsResponse
import com.faridrama123.core.domain.model.Teams
import com.faridrama123.core.domain.repository.ITeamRepository
import com.faridrama123.core.utlis.AppExecutors
import com.faridrama123.core.utlis.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITeamRepository {

    override fun getAllTeam(league : String): Flow<Resource<List<Teams>>> =
        object : NetworkBoundResource<List<Teams>, List<TeamsResponse>>() {
            override fun loadFromDB(): Flow<List<Teams>> {
                return localDataSource.getAllTeam().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Teams>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TeamsResponse>>> {
                return remoteDataSource.getAllTeam(league)
            }

            override suspend fun saveCallResult(data: List<TeamsResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                return localDataSource.insertTeam(teamList)
            }

        }.asFlow()

    override fun getFavoriteTeam(): Flow<List<Teams>> {
        return localDataSource.getFavoriteTeam().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTeam(team: Teams, state: Boolean) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }
}