package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shwordle.database.ProfileDatabase
import com.example.shwordle.databinding.ProfileBinding

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.profile, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ProfileDatabase.getInstance(application).profileDao
        val viewModelFactory =
            ProfileViewModelFactory(dataSource, application)
        val profileViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ProfileViewModel::class.java)
        profileViewModel.getProfile()
        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this
        binding.GamesPlayedNum.setText((profileViewModel.profile.value?.gamesPlayed.toString()))
        return binding.root
    }
}