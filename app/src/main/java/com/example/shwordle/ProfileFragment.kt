package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shwordle.databinding.ProfileBinding


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ProfileBinding.inflate(layoutInflater)
        binding.name.text = "Hello ${Profile.name}"
        binding.gamesPlayed.text = "Played: ${Profile.gamesPlayed}"
        binding.gamesWon.text = "Won: ${Profile.gamesWon}"
        binding.gamesLost.text = "Lost: ${Profile.gamesLost}"
        return binding.root
    }
}