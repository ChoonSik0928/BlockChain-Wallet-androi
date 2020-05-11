package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.os.Bundle
import android.view.View
import com.choonsik.blockchainwallet.R
import com.choonsik.blockchainwallet.base.BaseFragment
import com.choonsik.blockchainwallet.common.EventObserver
import com.choonsik.blockchainwallet.databinding.PinRegCodeFragmentBinding

class PinCodeRegFragment : BaseFragment<PinCodeRegViewModel, PinRegCodeFragmentBinding>(
    R.layout.pin_reg_code_fragment,
    PinCodeRegViewModel::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.firstPinClick.observe(viewLifecycleOwner, EventObserver {
            binding.lavFirst.setAnimation(R.raw.pin_code)
            binding.lavFirst.playAnimation()
        })
    }
}