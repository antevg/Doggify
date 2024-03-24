package com.eacipher.doggify

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.eacipher.doggify.di.sharedModules
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        //  startKoin { modules(getAllSharedModules()) }
        INSTANCE = this
        startKoin {
            modules(sharedModules)
        }
    }
}

class AppActivity : ComponentActivity(), KoinComponent {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

     //       App()
        }
    }
}