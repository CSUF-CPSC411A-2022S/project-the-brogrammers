package com.example.shwordle

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shwordle.database.ProfileDatabase
import com.example.shwordle.databinding.GameboardBinding
import com.example.shwordle.databinding.ProfileBinding


class GameboardFragment : Fragment() {
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
            ViewModelProvider(this, viewModelFactory).get(ProfileViewModel::class.java)

        binding.profileViewModel = profileViewModel

        binding.profileButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameboardFragment_to_profileFragment)
        }

        binding.create.setOnClickListener {
            profileViewModel.insert()
        }

        return binding.root
    }
}