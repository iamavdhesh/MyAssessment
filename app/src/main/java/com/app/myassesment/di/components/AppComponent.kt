package com.app.myassesment.di.components

import com.app.myassesment.core.MyApp
import com.app.myassesment.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * AndroidInjectionModule::class to support Dagger
 * AppModule::class is loading all modules for app
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: MyApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)

}
