package com.swordfish.lemuroid.lib.emulator

object LibretroBridge {
    /**
     * 呼叫 Libretro 的 retro_cheat_reset API
     * 重置目前模擬器核心中的所有金手指
     */
    external fun nativeCheatReset()

    /**
     * 呼叫 Libretro 的 retro_cheat_set API
     * @param index 金手指索引 (從 0 開始)
     * @param enabled 是否啟用 (true/false)
     * @param code 金手指碼字串 (例如 "00EA-0001")
     */
    external fun nativeCheatSet(index: Int, enabled: Boolean, code: String)
}
