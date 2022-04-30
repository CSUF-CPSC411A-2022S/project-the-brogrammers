package com.example.shwordle.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: Profile)

    @Update
    suspend fun update(profile: Profile)

    @Query("SELECT * from profile_table WHERE id = :key")
    fun get(key: Long): LiveData<Profile>?

    @Query("SELECT * from profile_table ORDER BY id DESC")
    fun getAllProfiles(): LiveData<List<Profile>>
}