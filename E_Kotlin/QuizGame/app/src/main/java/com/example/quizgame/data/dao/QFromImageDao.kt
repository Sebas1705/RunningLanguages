package com.example.quizgame.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizgame.data.entities.QFromImageEntity

@Dao
interface QFromImageDao {
    @Query("SELECT * FROM qFromImage_table")
     fun getAllQFromImage(): List<QFromImageEntity>
    @Query("SELECT * FROM qFromImage_table WHERE type = :type")
     fun getAllTypedQFromImage(type:String) : List<QFromImageEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQFromImage(qFromImage: QFromImageEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQFromImages(qFromImage: List<QFromImageEntity>)
}