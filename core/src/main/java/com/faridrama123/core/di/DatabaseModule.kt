package com.faridrama123.core.di

import android.content.Context
import androidx.room.Room
import com.faridrama123.core.data.source.local.room.TeamDao
import com.faridrama123.core.data.source.local.room.TeamDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TeamDatabase = Room.databaseBuilder(
        context,
        TeamDatabase::class.java, "Team.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTeamDao(database: TeamDatabase): TeamDao = database.teamDao()
}