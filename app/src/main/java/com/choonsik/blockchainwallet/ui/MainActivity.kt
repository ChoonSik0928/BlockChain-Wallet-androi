package com.choonsik.blockchainwallet.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.choonsik.blockchainwallet.databinding.ActivityMainBinding
import com.choonsik.blockchainwallet.extension.assistedActivityViewModels
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainViewModel by assistedActivityViewModels<MainActivityViewModel> { viewModelFactory }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
