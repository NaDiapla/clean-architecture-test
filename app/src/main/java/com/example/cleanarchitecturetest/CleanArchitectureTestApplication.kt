package com.example.cleanarchitecturetest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CleanArchitectureTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}