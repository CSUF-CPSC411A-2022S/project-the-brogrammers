package com.example.shwordle

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(

    @PrimaryKey(autoGenerate = true)
    var profileId: Long = 0L,

    @ColumnInfo()
    var gamesPlayed: Int = 0,

    @ColumnInfo()
    var gamesWon: Int = 0,

    @ColumnInfo()
    var gamesLost: Int = 0,

//    @ColumnInfo()
//    var difficultWords: Int = 0,
//
//    @ColumnInfo()
//    var FavoriteWords: Int = 0,
)

//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//
//class Profile(): ViewModel()  {
//    private val _gamesPlayed = MutableLiveData(0)
//    private val _gamesWon = MutableLiveData(0)
//    private val _gamesLost = MutableLiveData(0)
//
//    private val difficultWords = mutableListOf<String>()
//    private val favoriteTopics = mutableListOf<String>()
//
//    val gamesPlayed: LiveData<Int>
//        get() {
//            return _gamesPlayed
//        }
//    val gamesWon: LiveData<Int>
//        get() {
//            return _gamesWon
//        }
//    val gamesLost: LiveData<Int>
//        get() {
//            return _gamesLost
//        }
//
//    init {
//        _gamesPlayed.value = 0
//        _gamesWon.value = 0
//        _gamesLost.value = 0
//    }
//}