package com.app.myassesment.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.myassesment.di.base.ViewModelFactory
import com.app.myassesment.di.base.ViewModelKey
import com.app.myassesment.view.ProfileCardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Avdhesh Kumar on 06,Sept,2020
 */

@Module
abstract class ViewModelModule {

    /**
     * Binding ProfileCardViewModel using this key "ProfileCardViewModel::class"
     * So you can get ProfileCardViewModel using "ProfileCardViewModel::class" key from factory
     */
    @Binds
    @IntoMap
    @ViewModelKey(ProfileCardViewModel::class)
    abstract fun profileViewModel(profileCardViewModel: ProfileCardViewModel): ViewModel

    /**
     * Binds ViewModels factory to provide ViewModels.
     */
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
