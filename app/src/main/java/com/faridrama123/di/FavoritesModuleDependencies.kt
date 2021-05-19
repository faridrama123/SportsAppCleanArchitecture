package com.faridrama123.di

import com.faridrama123.core.domain.usecase.TeamUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavoritesModuleDependencies {

    fun teamUseCase(): TeamUseCase
}