package com.swordfish.lemuroid.app.mobile.feature.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.swordfish.lemuroid.R

class CheatBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_cheat_manager, container, false)
    }

    companion object {
        const val TAG = "CheatBottomSheetDialog"
        
        fun newInstance(gameId: Long): CheatBottomSheetDialog {
            return CheatBottomSheetDialog().apply {
                arguments = Bundle().apply {
                    putLong("GAME_ID", gameId)
                }
            }
        }
    }
}
