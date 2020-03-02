package com.choonsik.blockchainwallet.di

import com.choonsik.blockchainwallet.di.annotation.ActivityScoped
import com.choonsik.blockchainwallet.ui.MainActivity
import dagger.Module

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    internal abstract fun getMainActivity() : MainActivity
}