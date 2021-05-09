package com.faridrama123.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faridrama123.core.domain.usecase.TeamUseCase
import javax.inject.Inject

class NotificationsViewModel  (teamUseCase: TeamUseCase): ViewModel() {
    val favoriteTeam = teamUseCase.getFavoriteTeam().asLiveData()



}