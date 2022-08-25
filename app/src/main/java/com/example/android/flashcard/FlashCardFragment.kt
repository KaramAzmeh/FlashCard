package com.example.android.flashcard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.flashcard.databinding.FragmentFlashCardBinding


class FlashCardFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentFlashCardBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_flash_card,container,false
        )

        val flashCardViewModel = FlashCardViewModel()

        binding.apply {
            viewModel = flashCardViewModel
            lifecycleOwner = this@FlashCardFragment
        }

        flashCardViewModel.showAnswer.observe(viewLifecycleOwner) {
            if(it) {
                binding.questionImage.visibility = View.INVISIBLE
                binding.answer.visibility = View.VISIBLE
            }
            else {
                binding.questionImage.visibility = View.VISIBLE
                binding.answer.visibility = View.INVISIBLE
            }
        }

        binding.next.setOnClickListener {
            flashCardViewModel.next()
            flashCardViewModel.card.value?.let{ card ->
                binding.questionImage.setImageResource(card.picture)
            }
        }

        binding.prev.setOnClickListener {
            flashCardViewModel.prev()
            flashCardViewModel.card.value?.let{ card ->
                binding.questionImage.setImageResource(card.picture)
            }
        }

        return binding.root
    }
    companion object{
        val TAG = "FlashCardFragment"
    }
}