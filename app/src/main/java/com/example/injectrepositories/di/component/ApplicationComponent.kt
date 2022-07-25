package com.example.injectrepositories.di.component

import com.example.injectrepositories.di.module.NetworkModule
import com.example.injectrepositories.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun createActivitySubcomponent() : MainActivitySubcomponent
}