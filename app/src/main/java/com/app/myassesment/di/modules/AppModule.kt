package com.app.myassesment.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.app.myassesment.repository.api.ApiServices
import com.app.myassesment.core.MyApp
import com.app.myassesment.repository.api.network.LiveDataCallAdapterFactoryForRetrofit
import com.app.myassesment.repository.db.profiles.ProfileRecordDao
import com.kotlin.mvvm.repository.db.AppDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Avdhesh Kumar on 06,Sept,2020
 */

@Module(includes = [ ActivityModule::class, ViewModelModule::class])
class AppModule {

    /**
     * Static variables to hold base url's etc.
     */
    companion object {
        private const val BASE_URL = "https://randomuser.me/"
    }


    /**
     * Provides ApiServices client for Retrofit
     */
    @Singleton
    @Provides
    fun provideProfileService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
            .build()
            .create(ApiServices::class.java)
    }


    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "profiles-db").build()
    }


    /**
     * Provides ProfileRecordDao an object to access ProfileRecordResponse.Result table from Database
     */
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): ProfileRecordDao {
        return db.profileRecordDao()
    }

    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: MyApp): Context {
        return application.applicationContext
    }

    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: MyApp): Resources = application.resources
}
