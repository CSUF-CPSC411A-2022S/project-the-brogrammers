package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shwordle.databinding.ProfileBinding


class Profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ProfileBinding.inflate(layoutInflater)
        binding.name.text = "Hello"

        return binding.root
    }
}