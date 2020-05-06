package com.choonsik.blockchainwallet.ui.pin_code

import androidx.lifecycle.ViewModel
import com.choonsik.blockchainwallet.di.annotation.FragmentScoped
import com.choonsik.blockchainwallet.di.annotation.ViewModelKey
import com.choonsik.blockchainwallet.ui.pin_code.regstration.PinCodeRegFragment
import com.choonsik.blockchainwallet.ui.pin_code.regstration.PinCodeRegViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class PinCodeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributePinCodeRegFragment(): PinCodeRegFragment

    @Binds
    @IntoMap
    @ViewModelKey(PinCodeRegViewModel::class)
    abstract fun bindPinCodeRegViewModel(viewModel: PinCodeRegViewModel) : ViewModel
}