package com.example.injectrepositories

import android.app.Application
import com.example.injectrepositories.di.component.ApplicationComponent
import com.example.injectrepositories.di.component.DaggerApplicationComponent

class Application : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent.create()
    }
}