package com.compose.ui.architecture.coordinator.di

import com.compose.ui.architecture.coordinator.nav.Navigator
import com.compose.ui.architecture.coordinator.nav.UserCoordinator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    fun provideUserCoordinator(navigator: Navigator): UserCoordinator {
        return UserCoordinator(navigator)
    }


    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}