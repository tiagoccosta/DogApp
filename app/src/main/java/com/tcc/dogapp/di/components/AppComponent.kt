package com.tcc.dogapp.di.components


import android.content.SharedPreferences
import com.tcc.dogapp.di.modules.AppModule
import com.tcc.dogapp.di.modules.NetModule
import com.tcc.dogapp.mvp.models.network.interfaces.DogApiInterface
import com.tcc.dogapp.mvp.presenters.Presenter
import com.tcc.dogapp.mvp.views.interfaces.ActivityBaseInterface
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun inject(activity: ActivityBaseInterface)

    //downstream components need these exposed
    fun retrofit(): Retrofit

    fun okHttpClient(): OkHttpClient
    fun sharedPreferences(): SharedPreferences
    fun gitHubApiInterface(): DogApiInterface
    fun presenter(): Presenter
}