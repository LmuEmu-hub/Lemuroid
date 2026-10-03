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
    @Query("SELECT * FROM cheat_codes WHERE gameId = :gameId")
    fun getCheatsForGame(gameId: Long): Flow<List<CheatCode>>

    @Query("SELECT * FROM cheat_codes WHERE gameId = :gameId AND enabled = 1")
    suspend fun getEnabledCheatsForGame(gameId: Long): List<CheatCode>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(cheatCode: CheatCode)

    @Delete
    suspend fun delete(cheatCode: CheatCode)
}
