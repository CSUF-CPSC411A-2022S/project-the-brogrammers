package com.example.shwordle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shwordle.database.ProfileDao

class ProfileViewModel(
    val database: ProfileDao,
    application: Application) : AndroidViewModel(application) {
        var gamesPlayed = MutableLiveData(0)
        var gamesWon = MutableLiveData(0)
        var gamesLost = MutableLiveData(0)


}