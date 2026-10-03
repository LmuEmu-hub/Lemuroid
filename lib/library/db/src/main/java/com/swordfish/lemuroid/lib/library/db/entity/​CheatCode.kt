package com.swordfish.lemuroid.lib.library.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cheat_codes")
data class CheatCode(
    @PrimaryKey(autoGenerate = true) 
    val id: Long = 0,
    val gameId: Long,
    val description: String,
    val code: String,
    val enabled: Boolean = true
)
