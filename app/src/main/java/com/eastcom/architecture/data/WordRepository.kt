package com.eastcom.architecture.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.eastcom.architecture.dao.WordDao
import com.eastcom.architecture.entity.Word

class WordRepository(private val wordDao:WordDao){

    val allWords:LiveData<List<Word>> = wordDao.query()

    @WorkerThread
    suspend fun insert(word:Word){
        wordDao.insert(word)
    }
}