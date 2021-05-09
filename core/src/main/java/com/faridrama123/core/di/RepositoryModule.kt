package com.faridrama123.core.di

import com.faridrama123.core.data.TeamRepository
import com.faridrama123.core.domain.repository.ITeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(teamRepository: TeamRepository): ITeamRepository

}