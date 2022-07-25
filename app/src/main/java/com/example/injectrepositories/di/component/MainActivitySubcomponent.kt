package com.example.injectrepositories.di.component

import com.example.injectrepositories.MainActivity
import com.example.injectrepositories.di.module.MainActivityModule
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubcomponent {

    fun inject(mainActivity: MainActivity)
}