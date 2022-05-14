package com.example.shwordle.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDao2 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile2: Profile2)

    @Update
    suspend fun update(profile2: Profile2)

    @Query("SELECT * from profile_table2 WHERE id = :id")
    fun get(id: Int): LiveData<Profile2>
}