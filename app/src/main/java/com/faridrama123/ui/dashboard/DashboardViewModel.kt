package com.faridrama123.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faridrama123.core.data.Resource
import com.faridrama123.core.domain.model.Teams
import com.faridrama123.core.domain.usecase.TeamUseCase

class DashboardViewModel @ViewModelInject constructor( teamUseCase: TeamUseCase): ViewModel() {


    val getTeams =  teamUseCase.getAllTeam("English Premier League").asLiveData()



}