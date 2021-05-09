package com.faridrama123.favorites

import android.content.Context
import com.faridrama123.di.FavoritesModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoritesModuleDependencies::class])
interface FavoritesComponent {

    fun inject(fragment: NotificationsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoritesModuleDependencies: FavoritesModuleDependencies): Builder
        fun build(): FavoritesComponent
    }

}