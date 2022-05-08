package com.example.shwordle

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
            val letterTwo: String = binding.letterTwo2.text.toString().lowercase()
            val letterThree: String = binding.letterThree2.text.toString().lowercase()

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
            Toast.makeText(application, wordGuessed, Toast.LENGTH_SHORT).show()
            binding.address.setText(word)
            var result = wordGuessed.compareTo(word)
            CheckifCorrect(result)

            if(i != 5) {
                if (result == 0) {
                    val toast =
                        Toast.makeText(application, "words are equal", Toast.LENGTH_SHORT)
                    toast.show()
                    binding.announcer.setText("Correct!!")
                    profileViewModel.updateGamesWon()
                    // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
                }else{
                    ++i
                    val toast =
                        Toast.makeText(application, "words are not equal", Toast.LENGTH_SHORT)
                    toast.show()
                    binding.announcer.setText("not quite ")
                    val wordArray = Array(wordGuessed.length) {wordGuessed[it].toString() }
                    val word = Array(word.length) {word[it].toString() }
                    val t = word.size
                    // TODO for length of array, compare arrays to check for dupes
                }
                /*
                if(wordGuessed.contains(word, true)){
                    val wordArray = Array(wordGuessed.length) {wordGuessed[it].toString() }
                    lettersRight.setText(word)
                 */
                // TODO uses a contains method to check if letters are correct; doesn't work

            }else if(i == 5){
                val toast =
                    Toast.makeText(application, "Out of tries", Toast.LENGTH_SHORT)
                toast.show()
                binding.announcer.setText("Failed")

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
        /*
        val toast =
            Toast.makeText(this, "words are equal", Toast.LENGTH_SHORT)
        toast.show()
        //binding.announcer.setText("Failed")
        // TODO letterOne.filters = arrayOf(InputFilter.LengthFilter(10)) setting all previous grid to unmutable
        *
         */
    }
}