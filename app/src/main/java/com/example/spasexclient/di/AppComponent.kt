package com.example.spasexclient.di

import com.example.spasexclient.ui.home.HomeViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(homeViewModel: HomeViewModel)
}