package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shwordle.database.Profile
import com.example.shwordle.databinding.ProfileBinding


class ProfileFragment : Fragment() {
    private val viewModel: Profile by viewModels()
     private lateinit var binding: ProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile, container, false)
        return binding.root
    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val tracker: Profile by viewModels()
//        val binding = ProfileBinding.inflate(layoutInflater)
//        binding.name.text = "Hello"
//        binding.gamesPlayed.text = "Played: ${Profile.gamesPlayed}"
//        binding.gamesWon.text = "Won: ${Profile.gamesWon}"
//        binding.gamesLost.text = "Lost: ${Profile.gamesLost}"
//
//        var topicsListAdapter = WordListAdapter(Profile.difficult)
//        return binding.root
//    }
}