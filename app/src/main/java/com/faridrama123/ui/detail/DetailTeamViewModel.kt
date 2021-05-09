package com.faridrama123.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.faridrama123.core.domain.model.Teams
import com.faridrama123.core.domain.usecase.TeamUseCase

class DetailTeamViewModel @ViewModelInject constructor(private val teamUseCase: TeamUseCase): ViewModel() {
    fun setFavoriteTeam(team: Teams, newStatus : Boolean){
        return teamUseCase.setFavoriteTeam(team,newStatus)
    }

}