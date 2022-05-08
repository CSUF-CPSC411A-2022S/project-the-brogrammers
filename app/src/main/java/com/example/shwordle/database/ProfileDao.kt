package com.example.shwordle.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile: Profile)

    @Update
    suspend fun update(profile: Profile)

    @Query("SELECT * from profile_table WHERE id = :id")
    fun get(id: Int): LiveData<Profile>

    @Query("SELECT * from profile_table WHERE id = :id")
    suspend fun get2(id: Int): Profile
}