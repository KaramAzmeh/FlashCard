package com.example.android.flashcard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlashCardViewModel: ViewModel() {

    data class Card(val picture: Int, val answer: String)



    private val _cards = listOf(
        Card(R.drawable.wizard, "Wizard"),
        Card(R.drawable.lion, "Lion"),
        Card(R.drawable.owl, "Owl"),
        Card(R.drawable.mustard, "Mustard"),
        )

    private var _index = 0


    private var _showAnswer = MutableLiveData(false)

    val showAnswer : LiveData<Boolean>
    get() = _showAnswer

    private val _card = MutableLiveData(_cards[_index])

    val card : LiveData<Card>
    get() = _card

    fun flipCard() {
        _showAnswer.value?.let {
            _showAnswer.value = !it
        }
    }

    fun next(){
        _index++
        if (_index>_cards.lastIndex) _index = 0
        _card.value = _cards[_index]
        Log.i(TAG, "Index value is: $_index")
    }

    fun prev(){
        _index--
        if (_index<0) _index = _cards.lastIndex
        _card.value = _cards[_index]
        Log.i(TAG, "Index value is: $_index")
    }

    companion object{
        val TAG = "FlashCardViewModel"
    }
}