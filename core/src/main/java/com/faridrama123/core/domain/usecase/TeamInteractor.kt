package com.faridrama123.core.domain.usecase

import com.faridrama123.core.domain.model.Teams
import com.faridrama123.core.domain.repository.ITeamRepository
import javax.inject.Inject

class TeamInteractor @Inject constructor (private val teamRepository: ITeamRepository) : TeamUseCase{

    override fun getAllTeam(league : String) = teamRepository.getAllTeam(league)
    override fun getFavoriteTeam() = teamRepository.getFavoriteTeam()
    override fun setFavoriteTeam(team: Teams, state: Boolean) = teamRepository.setFavoriteTeam(team, state)
}
