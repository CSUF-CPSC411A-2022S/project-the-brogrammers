package com.example.shwordle

class Profile {
    companion object {
        var name = "Player"
        var gamesPlayed = 0
        var gamesWon = 0
        var gamesLost = 0

        //Have the top 10 difficult words
        var difficultWords = mutableListOf<String>()
        var favoriteTopics = mutableListOf<String>()
    }

}