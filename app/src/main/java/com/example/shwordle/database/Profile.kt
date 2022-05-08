package com.example.shwordle.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    @ColumnInfo()
    var gamesPlayed: Int = 0,
    @ColumnInfo()
    var gamesWon: Int = 0,
    @ColumnInfo()
    var gamesLost: Int = 0,
)