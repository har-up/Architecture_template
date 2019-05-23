package com.eastcom.architecture.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eastcom.architecture.entity.Word

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Delete
    fun delete(word: Word)

    @Update
    fun update(word: Word)

    @Query("select * from word_table")
    fun query():LiveData<List<Word>>

    @Query("delete from word_table")
    fun deleteAll()
}