package com.example.shwordle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shwordle.database.ProfileDao

class ProfileViewModel(
    val database: ProfileDao,
    application: Application) : AndroidViewModel(application) {
        var gamesPlayed = MutableLiveData<Int>(0)
        var gamesWon = MutableLiveData<Int>(0)
        var gamesLost = MutableLiveData<Int>(0)
        val profileList = database.getAllProfiles()

}