package com.sebss.pass_word.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sebss.pass_word.data.entities.WordEntity

@Dao
interface WordDao {
    @Query("SELECT * FROM words_table ORDER BY name ASC")
    suspend fun getAllWords(): List<WordEntity>

    @Query("SELECT * FROM words_table WHERE name = :name")
    suspend fun getWord(name: String): WordEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: WordEntity)

    @Insert
    suspend fun insertWords(words: List<WordEntity>)

    @Update
    suspend fun updateWord(word: WordEntity)

    @Delete
    suspend fun deleteWord(word: WordEntity)
}