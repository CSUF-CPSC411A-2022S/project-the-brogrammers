package com.example.shwordle.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table2")
data class Profile2(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    @ColumnInfo()
    var word: String = "",
)