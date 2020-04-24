package com.choonsik.blockchainwallet.ui.splash

import androidx.lifecycle.ViewModel
import com.choonsik.blockchainwallet.di.annotation.FragmentScoped
import com.choonsik.blockchainwallet.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class SplashModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeSplashFragment(): SplashFragment

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel) : ViewModel
}