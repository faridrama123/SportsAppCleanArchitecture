package com.faridrama123.core.data.source.remote


import android.util.Log
import com.faridrama123.core.data.source.remote.network.ApiResponse
import com.faridrama123.core.data.source.remote.network.ApiService
import com.faridrama123.core.data.source.remote.response.TeamsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getAllTeam (league : String) : Flow<ApiResponse<List<TeamsResponse>>>{
        return flow {
            try {
                val response = apiService.getListTeam(league)
                val dataArray = response.teams
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                }else{
                    emit((ApiResponse.Empty))
                }

            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }
}