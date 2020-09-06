package com.app.myassesment.di.modules

import com.app.myassesment.view.CardProfilesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * All your Activities participating in DI would be listed here.
 */

@Module
abstract class ActivityModule {

    /**
     * Marking Activities to be available to contributes for Android Injector
     */
    @ContributesAndroidInjector
    abstract fun contributeProfilesActivity(): CardProfilesActivity

}
