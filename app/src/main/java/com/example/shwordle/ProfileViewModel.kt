package com.example.shwordle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shwordle.database.ProfileDao
import com.example.shwordle.database.ProfileDatabase

class ProfileViewModel(
    val database: ProfileDao,
    application: Application) : AndroidViewModel(application) {
        var
}