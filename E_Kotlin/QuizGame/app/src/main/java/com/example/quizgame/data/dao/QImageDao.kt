package com.example.quizgame.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizgame.data.entities.QImageEntity

@Dao
interface QImageDao {
    @Query("SELECT * FROM qImage_table")
     fun getAllQImage(): List<QImageEntity>
    @Query("SELECT * FROM qImage_table WHERE type = :type")
     fun getAllTypedQImage(type:String): List<QImageEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQImage(qImage: QImageEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQImages(qImage: List<QImageEntity>)
}