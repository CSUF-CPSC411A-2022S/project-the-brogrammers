package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.shwordle.databinding.GameboardBinding


class GameboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GameboardBinding.inflate(layoutInflater)
        binding.profileButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameboardFragment_to_profileFragment)
        }


        return binding.root
    }
}