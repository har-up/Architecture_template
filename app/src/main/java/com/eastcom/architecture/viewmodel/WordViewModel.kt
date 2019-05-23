package com.eastcom.architecture.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eastcom.architecture.data.WordRepository
import com.eastcom.architecture.db.WordRoomDatabase
import com.eastcom.architecture.entity.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val mRepository:WordRepository

    val allWords:LiveData<List<Word>>
    init {
        val wordDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        mRepository = WordRepository(wordDao)
        allWords = mRepository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch (Dispatchers.IO){
        mRepository.insert(word)
    }
}