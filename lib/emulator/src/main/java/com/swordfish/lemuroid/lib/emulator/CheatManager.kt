package com.swordfish.lemuroid.lib.emulator

import com.swordfish.lemuroid.lib.library.db.dao.CheatCodeDao
import com.swordfish.lemuroid.lib.library.db.entity.CheatCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheatManager(private val cheatCodeDao: CheatCodeDao) {

    /**
     * 載入特定遊戲的所有金手指並應用至模擬器核心
     */
    suspend fun applyCheatsForGame(gameId: Long) = withContext(Dispatchers.IO) {
        val cheats = cheatCodeDao.getCheatsForGameSync(gameId)
        
        // 重置模擬器核心中的所有金手指
        LibretroBridge.nativeCheatReset()
        
        // 逐一設定啟用的金手指
        cheats.filter { it.enabled }.forEachIndexed { index, cheat ->
            LibretroBridge.nativeCheatSet(index, true, cheat.code)
        }
    }
}
