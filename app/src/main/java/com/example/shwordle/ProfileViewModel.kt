package com.example.shwordle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shwordle.database.Profile
import com.example.shwordle.database.ProfileDao
import kotlinx.coroutines.launch

class ProfileViewModel(
    val database: ProfileDao,
    application: Application):
    AndroidViewModel(application) {
    var profile = database.get(0)


    fun insert(){
        viewModelScope.launch {
            var newProfile = Profile()
            newProfile.id = 0
            newProfile.gamesPlayed = 0
            database.insert(newProfile)
        }
    }

    fun updateGamesPlayed(){
        viewModelScope.launch {
            var tempProfile = database.get2(0)
            tempProfile.gamesPlayed = tempProfile.gamesPlayed + 1
            database.update(tempProfile)
        }
    }

    fun updateGamesWon(){
        viewModelScope.launch {
            var tempProfile = database.get2(0)
            tempProfile.gamesWon = tempProfile.gamesWon + 1
            database.update(tempProfile)
        }
    }

    fun updateGamesLost(){
        viewModelScope.launch {
            var tempProfile = database.get2(0)
            tempProfile.gamesLost = tempProfile.gamesLost + 1
            database.update(tempProfile)
        }
    }

    fun gets(){
        profile = database.get(0)
    }
}