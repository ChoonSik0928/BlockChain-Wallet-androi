package com.choonsik.blockchainwallet.di.module

import com.choonsik.blockchainwallet.di.annotation.ActivityScoped
import com.choonsik.blockchainwallet.ui.MainActivity
import dagger.Module

//TODO UI Module 추가
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    internal abstract fun getMainActivity() : MainActivity
}