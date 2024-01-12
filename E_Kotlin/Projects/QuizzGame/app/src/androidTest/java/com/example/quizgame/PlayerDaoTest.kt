package com.example.quizgame

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.data.dao.PlayerDao
import com.example.quizgame.data.entities.PlayerEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlayerDaoTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var playerDao: PlayerDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        playerDao = appDatabase.playerDao()
    }

    @After
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun insertAndGetPlayers() = runBlocking {
        val player = PlayerEntity(id = 1, name = "Ejemplo", score = 100)

        // Insertar
        playerDao.insertPlayer(player)

        // Obtener todos los jugadores
        val players = playerDao.getAllPlayers().first()

        // Verificar
        assertEquals(1, players.size)
        assertEquals("Ejemplo", players[0].name)
        assertEquals(100, players[0].score)
    }

    @Test
    fun getPlayerById() = runBlocking {
        val player = PlayerEntity(id = 1, name = "Ejemplo", score = 100)

        // Insertar
        playerDao.insertPlayer(player)

        // Obtener por ID
        val playerObtained = playerDao.getPlayer(1).first()

        // Verificar
        assertNotNull(playerObtained)
        assertEquals("Ejemplo", playerObtained.name)
        assertEquals(100, playerObtained.score)
    }

    // Puedes agregar más pruebas según las operaciones que realices en tu DAO
}
