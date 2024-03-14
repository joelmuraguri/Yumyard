package com.joel.yumyard

import android.app.Application
import com.joel.yumyard.di.AppDataContainer
import com.joel.yumyard.di.DefaultAppContainer
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

class RecipeApp : Application() {

    lateinit var container: AppDataContainer
    override fun onCreate() {
        super.onCreate()
        plantDebugBuildLogger()
        container = DefaultAppContainer()
    }

    private fun plantDebugBuildLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}