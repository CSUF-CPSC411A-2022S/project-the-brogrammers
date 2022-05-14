package com.example.shwordle.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile2::class], version = 1, exportSchema = false)
abstract class ProfileDatabase2: RoomDatabase() {

    abstract val profileDao2: ProfileDao2

    companion object{
        @Volatile
        private var INSTANCE: ProfileDatabase2? = null // This class

        fun getInstance(context: Context): ProfileDatabase2 {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase2::class.java,
                        "profile_database2"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}