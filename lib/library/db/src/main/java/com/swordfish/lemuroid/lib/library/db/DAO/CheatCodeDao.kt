package com.swordfish.lemuroid.lib.library.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swordfish.lemuroid.lib.library.db.entity.CheatCode
import kotlinx.coroutines.flow.Flow

@Dao
interface CheatCodeDao {
    // 取得某款遊戲的所有金手指
    @Query("SELECT * FROM cheat_codes WHERE gameId = :gameId")
    fun getCheatsForGame(gameId: Long): Flow<List<CheatCode>>

    // 取得某款遊戲目前「已開啟」的金手指
    @Query("SELECT * FROM cheat_codes WHERE gameId = :gameId AND enabled = 1")
    suspend fun getEnabledCheatsForGame(gameId: Long): List<CheatCode>

    // 新增或更新金手指
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(cheatCode: CheatCode)

    // 刪除金手指
    @Delete
    suspend fun delete(cheatCode: CheatCode)
}
