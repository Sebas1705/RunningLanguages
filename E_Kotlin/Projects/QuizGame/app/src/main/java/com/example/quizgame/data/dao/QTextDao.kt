package com.example.quizgame.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizgame.data.entities.QTextEntity

@Dao
interface QTextDao {
    @Query("SELECT * FROM qText_table")
     fun getAllQText(): List<QTextEntity>
    @Query("SELECT * FROM qText_table WHERE type = :type")
     fun getAllTypedQText(type:String): List<QTextEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQText(qText: QTextEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQTexts(qText: List<QTextEntity>)
}