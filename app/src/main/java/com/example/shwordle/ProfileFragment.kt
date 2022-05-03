package com.example.shwordle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shwordle.database.ProfileDatabase
import com.example.shwordle.databinding.ProfileBinding

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile, container, false)

        val binding = ProfileBinding.inflate(layoutInflater)
        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = ProfileDatabase.getInstance(application).profileDao

        // Create a factory that generates IntersectionViewModels connected to the database.
        val viewModelFactory = ProfileViewModelFactory(dataSource, application)

        val profileViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ProfileViewModel::class.java)
        binding.profileViewModel = profileViewModel

        return binding.root
    }
}