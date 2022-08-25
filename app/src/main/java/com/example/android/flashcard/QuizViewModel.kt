package com.example.android.flashcard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuizViewModel(val app: Application) : AndroidViewModel(app) {

    data class Question(val q: String, val ans: List<String>)

    private var _index = 0

    private val _questions = listOf(
        Question("question1",listOf("ans1","ans2","ans3")),
        Question("question2",listOf("answer1","answer","answer")),
        Question("question3",listOf("1","2","3")),
        Question("question4",listOf("a","b","c")),
    )

    private val _question = MutableLiveData(_questions[_index])

    val question: LiveData<Question>
        get() = _question

    fun nextQuestion(){
        _index++
        if (_index>_questions.lastIndex) _index = 0
    }



}