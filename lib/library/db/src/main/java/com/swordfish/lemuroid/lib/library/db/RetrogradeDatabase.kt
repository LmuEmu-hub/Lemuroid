package com.swordfish.lemuroid.lib.library.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swordfish.lemuroid.lib.library.db.dao.CheatCodeDao
import com.swordfish.lemuroid.lib.library.db.entity.CheatCode

@Database(
    entities = [
        CheatCode::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RetrogradeDatabase : RoomDatabase() {
    abstract fun cheatCodeDao(): CheatCodeDao
}
