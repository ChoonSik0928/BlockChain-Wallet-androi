package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView
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
        (binding.root as ViewGroup).layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        viewModel.pinClick.observe(viewLifecycleOwner, EventObserver {
            val index = it.index
            val key = it.key
            if (key == PinKey.BackKey) {
                when (index) {
                    1 -> clearInputImage(binding.lavFirst)
                    2 -> clearInputImage(binding.lavSecond)
                    3 -> clearInputImage(binding.lavThird)
                    4 -> clearInputImage(binding.lavFourth)
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

        viewModel.inputFinishAndClear.observe(viewLifecycleOwner, EventObserver {
            clearInputImage(binding.lavFirst)
            clearInputImage(binding.lavSecond)
            clearInputImage(binding.lavThird)
            clearInputImage(binding.lavFourth)
        })
    }

    private fun startAnimation(lottieView: LottieAnimationView) {
        lottieView.setAnimation(R.raw.pin_code)
        lottieView.playAnimation()
    }

    private fun clearInputImage(lottieView: LottieAnimationView) {
        lottieView.setImageResource(0)
        lottieView.clearAnimation()
    }
}