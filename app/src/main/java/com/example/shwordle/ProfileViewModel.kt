package com.example.shwordle

import android.app.Application
import androidx.lifecycle.*
import com.example.shwordle.database.Profile
import com.example.shwordle.database.ProfileDao
import kotlinx.coroutines.launch

class ProfileViewModel(
    val database: ProfileDao,
    application: Application) : AndroidViewModel(application) {
        var gamesPlayed = MutableLiveData<Int>(0)
        var gamesWon = MutableLiveData<Int>(0)
        var gamesLost = MutableLiveData<Int>(0)
        var profile = database.get(1)

    fun insert(){
        viewModelScope.launch {
            var profile = Profile()
            profile.id = 1
            database.insert(profile)
        }
    }
    fun getProfile(){
        profile = database.get(1)
    }
}