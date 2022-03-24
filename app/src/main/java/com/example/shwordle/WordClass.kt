package com.example.shwordle

class KeyWord(var spelling: String, var length: Int,
              var correctCharList: List<Char>) {
    init{
        length = spelling.length
        correctCharList = spelling.map { it.lowercaseChar() }
    }

    fun checkSpelling(comparison: KeyWord){
        // TODO: insert a check between both objects.
    }
}

