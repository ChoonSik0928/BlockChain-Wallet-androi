package com.choonsik.blockchainwallet.ui.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.choonsik.blockchainwallet.R
import com.choonsik.blockchainwallet.base.BaseFragment
import com.choonsik.blockchainwallet.common.EventObserver
import com.choonsik.blockchainwallet.databinding.SplashFragmentBinding

class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>(
    R.layout.splash_fragment,
    SplashViewModel::class
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.animationView.addAnimatorUpdateListener {
            val progress = (it.animatedValue as Float * 100).toInt()
            if(progress >= 90){
                val direction = SplashFragmentDirections.actionSplashToPinCodeReg()
                binding.root.findNavController().navigate(direction)
            }
        }
//        viewModel.checkSecureSetting()
//        setObserver()
    }

    override fun onResume() {
        super.onResume()
        binding.animationView.resumeAnimation()
    }

    override fun onPause() {
        super.onPause()
        binding.animationView.pauseAnimation()
    }

    private fun setObserver() {
        viewModel.actionPinCodeRegistration.observe(viewLifecycleOwner, EventObserver {

        })
    }
}