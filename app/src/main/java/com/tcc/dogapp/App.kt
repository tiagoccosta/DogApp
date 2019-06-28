package com.tcc.dogapp

import android.app.Application
import com.tcc.dogapp.di.components.AppComponent
import com.tcc.dogapp.di.components.DaggerAppComponent
import com.tcc.dogapp.di.modules.AppModule
import com.tcc.dogapp.di.modules.NetModule
import com.tcc.dogapp.mvp.presenters.PresenterInterface


open class App : Application() {


    var endPoint: String = "https://api.thedogapi.com"

    var appComponent: AppComponent? = null
        private set

    var presenter: PresenterInterface? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this


        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(endPoint))
            .build()

        presenter = appComponent!!.presenter()

    }

    companion object {

        var instance: App? = null
    }
}