package com.example.spasexclient.di

import com.example.spasexclient.di.modules.NetworkModule
import com.example.spasexclient.ui.home.HomeFragment
import com.example.spasexclient.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun homeViewModelFactory(): HomeViewModel.HomeViewModelFactory
}