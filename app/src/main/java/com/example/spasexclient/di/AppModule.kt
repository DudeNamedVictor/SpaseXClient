package com.example.spasexclient.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideTest(): Test {
        return Test()
    }
}

class Test {
    fun test() = "Test test"
}