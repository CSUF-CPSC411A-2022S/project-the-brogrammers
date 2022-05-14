package com.example.shwordle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shwordle.database.Profile2
import com.example.shwordle.database.ProfileDao2
import kotlinx.coroutines.launch

class Profile2ViewModel(
    val database: ProfileDao2,
    application: Application):
    AndroidViewModel(application) {
    var profile2 = database.get(0)

/*
    fun insert(profile: Profile2()){
        viewModelScope.launch {
            //var newProfile = Profile2()
            profile.id = 0
            profile.word = ""
            database.insert(profile)
        }
    }
*/
    fun gets(){
        profile2 = database.get(0)
    }
}