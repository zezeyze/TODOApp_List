package com.zehrayildirim.todolistapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.zehrayildirim.todolistapp.databinding.HomePageBinding

class HomePage : Fragment() {
        private lateinit var binding: HomePageBinding
        @SuppressLint("ResourceType")
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = HomePageBinding.inflate(inflater,container,false)
            binding.btnNext.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_Home_to_FirstPage)
            }
            return binding.root
        }

    }