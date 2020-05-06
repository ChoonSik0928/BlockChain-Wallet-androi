package com.choonsik.blockchainwallet.di.module

import com.choonsik.blockchainwallet.di.annotation.ActivityScoped
import com.choonsik.blockchainwallet.ui.MainActivity
import com.choonsik.blockchainwallet.ui.MainActivityModule
import com.choonsik.blockchainwallet.ui.pin_code.PinCodeModule
import com.choonsik.blockchainwallet.ui.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            SplashModule::class,
            PinCodeModule::class
        ]
    )
    internal abstract fun getMainActivity(): MainActivity
}