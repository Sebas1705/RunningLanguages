package com.example.quizgame.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quizgame.data.entities.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    //Obtener todos los jugadores ordenados por la puntuación
    @Query("SELECT * FROM players_table ORDER BY score DESC")
    fun getAllPlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM players_table WHERE name = :name")
    suspend fun searchPlayerByName(name: String): PlayerEntity?

    // Insertar
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    // Insertar
    @Insert
    fun insertPlayers(players: List<PlayerEntity>)

    // Update
    @Update
    fun  updatePlayer(player: PlayerEntity)

    // Delete
    @Delete
    fun deletePlayer(player: PlayerEntity)
}