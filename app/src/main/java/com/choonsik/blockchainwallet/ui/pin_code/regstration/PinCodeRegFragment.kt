package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.os.Bundle
import android.util.Log
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable.RESTART
import com.airbnb.lottie.LottieDrawable.REVERSE
import com.choonsik.blockchainwallet.R
import com.choonsik.blockchainwallet.base.BaseFragment
import com.choonsik.blockchainwallet.common.EventObserver
import com.choonsik.blockchainwallet.databinding.PinRegCodeFragmentBinding
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard.PinKey

class PinCodeRegFragment : BaseFragment<PinCodeRegViewModel, PinRegCodeFragmentBinding>(
    R.layout.pin_reg_code_fragment,
    PinCodeRegViewModel::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pinClick.observe(viewLifecycleOwner, EventObserver {
            val index = it.index
            val key = it.key
            if (key == PinKey.BackKey) {
                when (index) {
                    1 -> revertAnimation(binding.lavFirst)
                    2 -> revertAnimation(binding.lavSecond)
                    3 -> revertAnimation(binding.lavThird)
                    4 -> revertAnimation(binding.lavFourth)
                }

            } else {
                when (index) {
                    1 -> startAnimation(binding.lavFirst)
                    2 -> startAnimation(binding.lavSecond)
                    3 -> startAnimation(binding.lavThird)
                    4 -> startAnimation(binding.lavFourth)
                }
            }
        })
    }

    private fun startAnimation(lottieView: LottieAnimationView) {
        lottieView.setAnimation(R.raw.pin_code)
        lottieView.playAnimation()
    }

    private fun revertAnimation(lottieView: LottieAnimationView) {
        lottieView.setImageResource(0)
        lottieView.clearAnimation()
    }
}