package com.example.android.flashcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.flashcard.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentQuizBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_slider,container, false
        )

        val quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        binding.viewModel = quizViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}