package com.example.shwordle

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.shwordle.database.ProfileDatabase
import com.example.shwordle.databinding.GameboardBinding


class GameboardFragment : Fragment() {
    lateinit var clearButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameboardBinding =
            DataBindingUtil.inflate(inflater, R.layout.gameboard, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = ProfileDatabase.getInstance(application).profileDao

        val viewModelFactory = ProfileViewModelFactory(dataSource, application)

        val profileViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ProfileViewModel::class.java)

        profileViewModel.insert()

        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this
        binding.gameOver.isVisible = false
        binding.gameWon.isVisible = false
        binding.devControl1.isVisible = false
        binding.devControl2.isVisible = false
        binding.devControl3.isVisible = false

        binding.profileButton.setOnClickListener { view: View ->
            profileViewModel.updateGamesPlayed()
            view.findNavController().navigate(R.id.action_gameboardFragment_to_profile_fragment)
        }

        val wordList = listOf("same", "able", "aged", "bell", "blow", "book", "card", "city", "case","dust", "draw", "door", "duke")
        var word = wordList.random()
        val addButton: Button = binding.add
        var i = 0


        fun GameMechanic () {
            var letterOne: String = binding.letterOne.text.toString().lowercase()
            var letterTwo: String = binding.letterTwo.text.toString().lowercase()
            var letterThree: String = binding.letterThree.text.toString().lowercase()
            var letterFour: String = binding.letterFour.text.toString().lowercase()

            var RTwoLetterOne: String = binding.RTwoLetterOne.text.toString().lowercase()
            var RTwoLetterTwo: String = binding.RTwoLetterTwo.text.toString().lowercase()
            var RTwoLetterThree: String = binding.RTwoLetterThree.text.toString().lowercase()
            var RTwoLetterFour: String = binding.RTwoLetterFour.text.toString().lowercase()

            var RThreeLetterOne: String = binding.RThreeLetterOne.text.toString().lowercase()
            var RThreeLetterTwo: String = binding.RThreeLetterTwo.text.toString().lowercase()
            var RThreeLetterThree: String = binding.RThreeLetterThree.text.toString().lowercase()
            var RThreeLetterFour: String = binding.RThreeLetterFour.text.toString().lowercase()

            var RFourLetterOne: String = binding.RFourLetterOne.text.toString().lowercase()
            var RFourLetterTwo: String = binding.RFourLetterTwo.text.toString().lowercase()
            var RFourLetterThree: String = binding.RFourLetterThree.text.toString().lowercase()
            var RFourLetterFour: String = binding.RFourLetterFour.text.toString().lowercase()

            var RFiveLetterOne: String = binding.RFiveLetterOne.text.toString().lowercase()
            var RFiveLetterTwo: String = binding.RFiveLetterTwo.text.toString().lowercase()
            var RFiveLetterThree: String = binding.RFiveLetterThree.text.toString().lowercase()
            var RFiveLetterFour: String = binding.RFiveLetterFour.text.toString().lowercase()


            var wordGuessed = letterOne + letterTwo + letterThree + letterFour
            if(wordGuessed.length != 4){
                binding.letterOne.setText("S")
                letterOne = "S"
                binding.letterTwo.setText("S")
                letterTwo = "S"
                binding.letterThree.setText("S")
                letterThree = "S"
                binding.letterFour.setText("S")
                letterFour = "S"
                wordGuessed = letterOne + letterTwo + letterThree + letterFour
            }

            if(i == 1){
                wordGuessed = RTwoLetterOne + RTwoLetterTwo + RTwoLetterThree + RTwoLetterFour
                if(wordGuessed.length != 4){
                    binding.RTwoLetterOne.setText("S")
                    RTwoLetterOne = "S"
                    binding.RTwoLetterTwo.setText("S")
                    RTwoLetterTwo = "S"
                    binding.RTwoLetterThree.setText("S")
                    RTwoLetterThree = "S"
                    binding.RTwoLetterFour.setText("S")
                    RTwoLetterFour = "S"
                    wordGuessed = RTwoLetterOne + RTwoLetterTwo + RTwoLetterThree + RTwoLetterFour
                }
            }
            if(i == 2){
                wordGuessed = RThreeLetterOne + RThreeLetterTwo + RThreeLetterThree + RThreeLetterFour
                if(wordGuessed.length != 4){
                    binding.RThreeLetterOne.setText("S")
                    RThreeLetterOne = "S"
                    binding.RThreeLetterTwo.setText("S")
                    RThreeLetterTwo = "S"
                    binding.RThreeLetterThree.setText("S")
                    RThreeLetterThree = "S"
                    binding.RThreeLetterFour.setText("S")
                    RThreeLetterFour = "S"
                    wordGuessed = RThreeLetterOne + RThreeLetterTwo + RThreeLetterThree + RThreeLetterFour
                }
            }
            if(i == 3){
                wordGuessed = RFourLetterOne + RFourLetterTwo + RFourLetterThree + RFourLetterFour
                if(wordGuessed.length != 4){
                    binding.RFourLetterOne.setText("S")
                    RFourLetterOne = "S"
                    binding.RFourLetterTwo.setText("S")
                    RFourLetterTwo = "S"
                    binding.RFourLetterThree.setText("S")
                    RFourLetterThree = "S"
                    binding.RFourLetterFour.setText("S")
                    RFourLetterFour = "S"
                    wordGuessed = RFourLetterOne + RFourLetterTwo + RFourLetterThree + RFourLetterFour
                }
            }
            if(i == 4){
                wordGuessed = RFiveLetterOne + RFiveLetterTwo + RFiveLetterThree + RFiveLetterFour
                if(wordGuessed.length != 4){
                    binding.RFiveLetterOne.setText("S")
                    RFiveLetterOne = "S"
                    binding.RFiveLetterTwo.setText("S")
                    RFiveLetterTwo = "S"
                    binding.RFiveLetterThree.setText("S")
                    RFiveLetterThree = "S"
                    binding.RFiveLetterFour.setText("S")
                    RFiveLetterFour = "S"
                    wordGuessed = RFiveLetterOne + RFiveLetterTwo + RFiveLetterThree + RFiveLetterFour
                }
            }
            // TODO make above initialization its own func ^^^

            binding.devControl1.setText(wordGuessed)
            binding.devControl2.setText(word)
            var result = wordGuessed.compareTo(word)
            CheckifCorrect(result)
            if(i != 6) {
                if (result == 0) {
                    binding.announcer.setText("Game Won")
                    profileViewModel.updateGamesWon()
                    binding.gameWon.isVisible = true
                    // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
                }else{
                    ++i

                    binding.announcer.setText("not quite ")
                    if(i == 5){
                        profileViewModel.updateGamesLost()
                        binding.announcer.setText("Game Over")
                        binding.gameOver.isVisible = true
                        binding.devControl2.isVisible = true
                    }
                    val wordArray = Array(wordGuessed.length) {wordGuessed[it].toString() }
                    val word = Array(word.length) {word[it].toString() }
                    var t = word.size
                    var wordsRight = ""
                    var p = 0
                    while(p != 4) {
                        //if(word[p] == wordArray[p]){
                            wordsRight += wordArray[p]
                            binding.devControl3.setText(wordsRight)

                            // Is there a better way to do this? Of course there is, did I find it before time was due? No, no I did not.
                            // Checks for location-based correctness and turns green per iteration of i (which is round checked)
                            if(i == 1){
                                if(word[0] == wordArray[0]) {
                                    binding.letterOne.setTextColor(Color.parseColor("#008000"))
                                } else if(word.contains(wordArray[0])){
                                    binding.letterOne.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.letterOne.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.letterTwo.setTextColor(Color.parseColor("#008000"))
                                } else if(word.contains(wordArray[1])){
                                    binding.letterTwo.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.letterTwo.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.letterThree.setTextColor(Color.parseColor("#008000"))
                                } else if(word.contains(wordArray[2])){
                                    binding.letterThree.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.letterThree.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[3] == wordArray[3]) {
                                    binding.letterFour.setTextColor(Color.parseColor("#008000"))
                                } else if(word.contains(wordArray[3])){
                                    binding.letterFour.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.letterFour.setTextColor(Color.parseColor("#708090"))
                                }
                            }
                            if(i == 2){
                                if(word[0] == wordArray[0]) {
                                    binding.RTwoLetterOne.setTextColor(Color.parseColor("#008000"))
                                } else if(word.contains(wordArray[0])){
                                    binding.RTwoLetterOne.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RTwoLetterOne.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RTwoLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[1])){
                                    binding.RTwoLetterTwo.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RTwoLetterTwo.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RTwoLetterThree.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[2])){
                                    binding.RTwoLetterThree.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RTwoLetterThree.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[3] == wordArray[3]) {
                                    binding.RTwoLetterFour.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[3])){
                                    binding.RTwoLetterFour.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RTwoLetterFour.setTextColor(Color.parseColor("#708090"))
                                }
                            }
                            if(i == 3){
                                if(word[0] == wordArray[0]) {
                                    binding.RThreeLetterOne.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[0])){
                                    binding.RThreeLetterOne.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RThreeLetterOne.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RThreeLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[1])){
                                    binding.RThreeLetterTwo.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RThreeLetterTwo.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RThreeLetterThree.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[2])){
                                    binding.RThreeLetterThree.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RThreeLetterThree.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[3] == wordArray[3]) {
                                    binding.RThreeLetterFour.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[3])){
                                    binding.RThreeLetterFour.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RThreeLetterFour.setTextColor(Color.parseColor("#708090"))
                                }
                            }
                            if(i == 4){
                                if(word[0] == wordArray[0]) {
                                    binding.RFourLetterOne.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[0])){
                                    binding.RFourLetterOne.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFourLetterOne.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RFourLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[1])){
                                    binding.RFourLetterTwo.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFourLetterTwo.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RFourLetterThree.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[2])){
                                    binding.RFourLetterThree.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFourLetterThree.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[3] == wordArray[3]) {
                                    binding.RFourLetterFour.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[3])){
                                    binding.RFourLetterFour.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFourLetterFour.setTextColor(Color.parseColor("#708090"))
                                }
                            }
                            if(i == 5){
                                if(word[0] == wordArray[0]) {
                                    binding.RFiveLetterOne.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[0])){
                                    binding.RFiveLetterOne.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFiveLetterOne.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RFiveLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[1])){
                                    binding.RFiveLetterTwo.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFiveLetterTwo.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RFiveLetterThree.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[2])){
                                    binding.RFiveLetterThree.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFiveLetterThree.setTextColor(Color.parseColor("#708090"))
                                }
                                if(word[3] == wordArray[3]) {
                                    binding.RFiveLetterFour.setTextColor(Color.parseColor("#008000"))
                                }else if(word.contains(wordArray[3])){
                                    binding.RFiveLetterFour.setTextColor(Color.parseColor("#FFFF00"))
                                } else{
                                    binding.RFiveLetterFour.setTextColor(Color.parseColor("#708090"))
                                }
                            }

                        //}
                        ++p
                    }
                    // TODO for length of array, compare arrays to check for dupes
                }
                // TODO uses a contains method to check if letters are correct; doesn't work

            }/*else if(i == 5){
                profileViewModel.updateGamesLost()
                binding.announcer.setText("Game Over")
            }*/

        }

        fun reset(){
            binding.announcer.setText("Welcome")
            word = wordList.random()
            binding.gameOver.isVisible = false
            binding.gameWon.isVisible = false
            binding.letterOne.setText("")
            binding.letterOne.setTextColor(Color.parseColor("#FFFFFF"))
            binding.letterTwo.setText("")
            binding.letterTwo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.letterThree.setText("")
            binding.letterThree.setTextColor(Color.parseColor("#FFFFFF"))
            binding.letterFour.setText("")
            binding.letterFour.setTextColor(Color.parseColor("#FFFFFF"))

            binding.RTwoLetterOne.setText("")
            binding.RTwoLetterOne.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RTwoLetterTwo.setText("")
            binding.RTwoLetterTwo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RTwoLetterThree.setText("")
            binding.RTwoLetterThree.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RTwoLetterFour.setText("")
            binding.RTwoLetterFour.setTextColor(Color.parseColor("#FFFFFF"))

            binding.RThreeLetterOne.setText("")
            binding.RThreeLetterOne.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RThreeLetterTwo.setText("")
            binding.RThreeLetterTwo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RThreeLetterThree.setText("")
            binding.RThreeLetterThree.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RThreeLetterFour.setText("")
            binding.RThreeLetterFour.setTextColor(Color.parseColor("#FFFFFF"))

            binding.RFourLetterOne.setText("")
            binding.RFourLetterOne.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFourLetterTwo.setText("")
            binding.RFourLetterTwo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFourLetterThree.setText("")
            binding.RFourLetterThree.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFourLetterFour.setText("")
            binding.RFourLetterFour.setTextColor(Color.parseColor("#FFFFFF"))

            binding.RFiveLetterOne.setText("")
            binding.RFiveLetterOne.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFiveLetterTwo.setText("")
            binding.RFiveLetterTwo.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFiveLetterThree.setText("")
            binding.RFiveLetterThree.setTextColor(Color.parseColor("#FFFFFF"))
            binding.RFiveLetterFour.setText("")
            binding.RFiveLetterFour.setTextColor(Color.parseColor("#FFFFFF"))
            i = 0
        }


        addButton.setOnClickListener {
            GameMechanic()
            if(i == 6){
                reset()
            }
        }

        binding.resetButton.setOnClickListener {
            reset()
        }

        return binding.root
    }

}
fun CheckifCorrect(result : Int) {
    if (result == 0) {
        // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
    }
}

