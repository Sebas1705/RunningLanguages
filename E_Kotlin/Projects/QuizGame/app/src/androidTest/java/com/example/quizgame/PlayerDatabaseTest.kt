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
class PlayerDatabaseTest {

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
        val player = PlayerEntity( name = "Ejemplo", score = 100)

        // Insertar
        playerDao.insertPlayer(player)

        // Obtener todos los jugadores
        val players = playerDao.getAllPlayers().first()

        // Verificar
        assertEquals(1, players.size)
        assertEquals("Ejemplo", players[0].name)
        assertEquals(100, players[0].score)
    }

    // Puedes agregar más pruebas según las operaciones que realices en tu DAO

    @Test
    fun insertAndGetPlayersFromDatabase() = runBlocking {
        // Supongamos que tienes una base de datos preexistente con algunos jugadores
        val firstPlayers = listOf(
            PlayerEntity(name = "Jugador1", score = 150),
            PlayerEntity(name = "Jugador2", score = 200)
        )

        appDatabase.playerDao().insertPlayers(firstPlayers)

        // Obtener todos los jugadores
        val players = playerDao.getAllPlayers().first()

        // Verificar
        assertEquals(2, players.size)
        assertEquals("Jugador2", players[0].name)
        assertEquals("Jugador1", players[1].name)
    }
}
