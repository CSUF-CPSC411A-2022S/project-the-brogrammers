package com.example.shwordle

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
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

        binding.profileButton.setOnClickListener { view: View ->
            profileViewModel.updateGamesPlayed()
            view.findNavController().navigate(R.id.action_gameboardFragment_to_profile_fragment)
        }

        val wordList = listOf("cat","bat", "fat", "mad", "run")
        val word = wordList.random()
        val addButton: Button = binding.add
        var i = 0
        //val result = 1;


        fun GameMechanic () {
            val letterOne: String = binding.letterOne.text.toString().lowercase()
            val letterTwo: String = binding.letterTwo.text.toString().lowercase()
            val letterThree: String = binding.letterThree.text.toString().lowercase()

            val RTwoLetterOne: String = binding.RTwoLetterOne.text.toString().lowercase()
            val RTwoLetterTwo: String = binding.RTwoLetterTwo.text.toString().lowercase()
            val RTwoLetterThree: String = binding.RTwoLetterThree.text.toString().lowercase()

            val RThreeLetterOne: String = binding.RThreeLetterOne.text.toString().lowercase()
            val RThreeLetterTwo: String = binding.RThreeLetterTwo.text.toString().lowercase()
            val RThreeLetterThree: String = binding.RThreeLetterThree.text.toString().lowercase()

            val RFourLetterOne: String = binding.RFourLetterOne.text.toString().lowercase()
            val RFourLetterTwo: String = binding.RFourLetterTwo.text.toString().lowercase()
            val RFourLetterThree: String = binding.RFourLetterThree.text.toString().lowercase()

            val RFiveLetterOne: String = binding.RFiveLetterOne.text.toString().lowercase()
            val RFiveLetterTwo: String = binding.RFiveLetterTwo.text.toString().lowercase()
            val RFiveLetterThree: String = binding.RFiveLetterThree.text.toString().lowercase()

            var wordGuessed = letterOne + letterTwo + letterThree
            if(i == 1){
                wordGuessed = RTwoLetterOne + RTwoLetterTwo + RTwoLetterThree
            }
            if(i == 2){
                wordGuessed = RThreeLetterOne + RThreeLetterTwo + RThreeLetterThree
            }
            if(i == 3){
                wordGuessed = RFourLetterOne + RFourLetterTwo + RFourLetterThree
            }
            if(i == 4){
                wordGuessed = RFiveLetterOne + RFiveLetterTwo + RFiveLetterThree
            }
            // TODO make above initialization its own func ^^^

            binding.name.setText(wordGuessed)
            binding.address.setText(word)
            var result = wordGuessed.compareTo(word)
            CheckifCorrect(result)
            //var wordsRight = ""

            if(i != 5) {
                if (result == 0) {
                    binding.announcer.setText("Correct")
                    // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
                }else{
                    ++i

                    binding.announcer.setText("not quite ")
                    val wordArray = Array(wordGuessed.length) {wordGuessed[it].toString() }
                    val word = Array(word.length) {word[it].toString() }
                    var t = word.size
                    var wordsRight = ""
                    var p = 0
                    while(p != 3) {
                        if(word[p] == wordArray[p]){
                            wordsRight += wordArray[p]
                            binding.LettersRight.setText(wordsRight)

                            // Is there a better way to do this? Of course there is, did I find it before time was due? No, no I did not.
                            // Checks for location-based correctness and turns green per iteration of i (which is round checked)
                            if(i == 1){
                                if(word[0] == wordArray[0]) {
                                    binding.letterOne.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.letterTwo.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.letterThree.setTextColor(Color.parseColor("#008000"))
                                }
                            }
                            if(i == 2){
                                if(word[0] == wordArray[0]) {
                                    binding.RTwoLetterOne.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RTwoLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RTwoLetterThree.setTextColor(Color.parseColor("#008000"))
                                }
                            }
                            if(i == 3){
                                if(word[0] == wordArray[0]) {
                                    binding.RThreeLetterOne.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RThreeLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RThreeLetterThree.setTextColor(Color.parseColor("#008000"))
                                }
                            }
                            if(i == 4){
                                if(word[0] == wordArray[0]) {
                                    binding.RFourLetterOne.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[1] == wordArray[1]) {
                                    binding.RFourLetterTwo.setTextColor(Color.parseColor("#008000"))
                                }
                                if(word[2] == wordArray[2]) {
                                    binding.RFourLetterThree.setTextColor(Color.parseColor("#008000"))
                                }
                            }

                        }
                        ++p
                    }
                    // TODO for length of array, compare arrays to check for dupes
                }
                // TODO uses a contains method to check if letters are correct; doesn't work

            }else if(i == 5){
                binding.announcer.setText("Game Over")
            }

        }

        addButton.setOnClickListener {
            GameMechanic()
        }

        return binding.root
    }

}
fun CheckifCorrect(result : Int) {
    if (result == 0) {
        // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
    }
}