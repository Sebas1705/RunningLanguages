package com.sebss.pass_word.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sebss.pass_word.data.entities.PlayerEntity

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players_table ORDER BY score DESC")
    suspend fun getAllPlayers(): List<PlayerEntity>

    @Query("SELECT * FROM players_table WHERE name = :name")
    suspend fun getPlayerByName(name: String): PlayerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    @Insert
    suspend fun insertPlayers(players: List<PlayerEntity>)

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Delete
    suspend fun deletePlayer(player: PlayerEntity)
}