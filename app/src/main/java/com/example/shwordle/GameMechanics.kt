package com.example.shwordle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private var word: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_game)
//        word = findViewById(R.id.resultText)
//
//        val name = generateShwordle(names)
//        val attemptViews = listOf<EditText>(
//            findViewById(R.id.guessText1),
//            findViewById(R.id.guessText2),
//            findViewById(R.id.guessText3),
//            findViewById(R.id.guessText4),
//            findViewById(R.id.guessText5),
//            findViewById(R.id.guessText6),
//        )
//
//        val editTextPositionMap = attemptViews.mapIndexed { index, editText ->  Pair(editText, index) }.toMap()
//
//        val guessButton = findViewById<Button>(R.id.guessButton)
//        guessButton.setOnClickListener {
//            enterGuess(name, attemptViews, editTextPositionMap[currentFocus]!!)
//        }
//
//        findViewById<EditText>(R.id.guessText1).requestFocus()
//    }
//
//    private fun enterGuess(name: String, attemptViews: List<EditText>, attempt: Int) {
//        val guessWord = attemptViews[attempt].text.toString()
//
//        println("GUESSWORD -> $guessWord")
//        println("NAME -> $name")
//
//        if (!validateGuess(guessWord)) {
//            word!!.text = String.format("Word not int the list")
//            return
//        }
//
//        val letterResults = guessWord
//            .mapIndexed { index, letter -> checkLetter(letter, index, name) }
//            .map {
//                when (it) {
//                    CORRECT -> 'G'
//                    PART_CORRECT -> 'A'
//                    INCORRECT -> 'R'
//                }
//            }
//            .joinToString(" | ")
//
//        word!!.text = String.format(letterResults)
//
//        if (attempt < attemptViews.indices.last) {
//            attemptViews[attempt + 1].requestFocus()
//        } else {
//            if (letterResults == "G | G | G | G | G") {
//                word!!.text = String.format("Well done!")
//            } else {
//                word!!.text = String.format("Bad luck!")
//            }
//        }
    }
}
