package com.faridrama123.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faridrama123.core.domain.usecase.TeamUseCase

class NotificationsViewModel  (teamUseCase: TeamUseCase): ViewModel() {
    val favoriteTeam = teamUseCase.getFavoriteTeam().asLiveData()

}