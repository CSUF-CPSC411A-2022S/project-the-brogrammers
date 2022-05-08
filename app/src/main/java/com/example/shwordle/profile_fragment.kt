package com.example.shwordle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shwordle.database.ProfileDatabase
import com.example.shwordle.databinding.ProfileFragmentBinding


class profile_fragment : Fragment() {
    override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        val binding: ProfileFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        val application = requireNotNull(this.activity).application

        val dataSource = ProfileDatabase.getInstance(application).profileDao
        val viewModelFactory =
            ProfileViewModelFactory(dataSource, application)
        val profileViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ProfileViewModel::class.java)
        profileViewModel.gets()
        profileViewModel.profile.observe(viewLifecycleOwner, Observer {
            profile -> binding.GamesPlayedNum.setText(profile?.gamesPlayed.toString())
            binding.GamesWonNum.setText(profile?.gamesWon.toString())
            binding.GamesLostNum.setText(profile?.gamesWon.toString())
        })

        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}