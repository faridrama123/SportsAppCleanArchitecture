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
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TeamDatabase {

        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)

        return  Room.databaseBuilder(
                context,
                TeamDatabase::
                class.java, "Team.db"
        ).fallbackToDestructiveMigration()
                .openHelperFactory(factory)
                .build()
    }


    @Provides
    fun provideTeamDao(database: TeamDatabase): TeamDao = database.teamDao()
}