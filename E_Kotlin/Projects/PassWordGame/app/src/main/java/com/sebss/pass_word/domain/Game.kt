package com.sebss.pass_word.domain

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.sebss.pass_word.R
import com.sebss.pass_word.data.AppDatabase
import com.sebss.pass_word.data.SharedPreferences
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.data.entities.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.Normalizer

class Game private constructor(context: Context)  {

    //Components:
    private val sharedPreferences = SharedPreferences(context)
    private val database: AppDatabase = AppDatabase.getInstance(context)
    val soundPlayer = SoundPlayer()

    //Variables:
    var player: PlayerEntity? = null
    var indexWord = 0
    var wordsGame: MutableList<WordEntity> = mutableListOf()
    private var corrects = 0
    private var incorrects = 0
    private var score = 0
    private val listOfIcons = listOf(
        R.drawable.user0,
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5
    )
    var dataFragment: Fragment? = null

    // Constructor -Singleton-
    companion object {

        private var instance: Game? = null
        fun getInstance(context:Context?): Game {
            if (instance == null) {
                instance = Game(context!!)
            }
            return instance!!
        }

        fun changeActivity(
            activity: AppCompatActivity,
            cls: Class<out AppCompatActivity>,
            clearOfTop: Boolean,
            animStart: Int = R.anim.zoom_in,
            animEnd: Int = R.anim.zoom_out
        ) {
            val intent = Intent(activity, cls)
            if (clearOfTop) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val options = ActivityOptionsCompat.makeCustomAnimation(activity, animStart, animEnd)
            ActivityCompat.startActivity(activity, intent, options.toBundle())
        }

        fun removeAccents(input: String): String {
            val normalizedString = Normalizer.normalize(input, Normalizer.Form.NFD)
            return normalizedString.replace("[^\\p{ASCII}]".toRegex(), "")
        }
    }

    //Game functions:
    fun changeIcon(right: Boolean): Int {
        player?.let {
            val index = listOfIcons.indexOf(it.imageIcon)
            if(index == 0) it.imageIcon = listOfIcons[if (right) 1 else listOfIcons.size-1]
            else it.imageIcon =
                listOfIcons[(listOfIcons.indexOf(it.imageIcon) + (if (right) 1 else -1)) % 6]
            updatePlayer(it)
            return it.imageIcon
        }
        return -1
    }
    fun generateWordsGame(filter: (word: WordEntity, letter: Char) -> Boolean) {
        wordsGame.clear()
        indexWord = 0
        corrects = 0
        incorrects = 0
        score = 0
        for (letter in "abcdefghijklmnopqrstuvxyz") {
            val wordsList = getAllWords().filter { filter(it, letter) }
            var actualWord: WordEntity
            do {
                actualWord = wordsList.random()
            } while (actualWord in wordsGame)
            wordsGame.add(actualWord)
        }
    }
    fun saveActualData() {
        player?.let {
            it.score += score
            it.correctCount += corrects
            it.incorrectCount += incorrects
            it.gamesCount += 1
            updatePlayer(it)
        }
    }
    fun loadLastPlayer(){
        val name = sharedPreferences.loadUser()
        if(name!=""&&name!=null){
            val pTemp=searchPlayer(name)
            if(pTemp!=null) loginPlayer(pTemp)
        }
    }
    fun loginPlayer(player: PlayerEntity) {
        this.player = player
        sharedPreferences.saveUser(player.name)
    }
    fun logoutPlayer() {
        this.player = null
        sharedPreferences.saveUser("")
    }
    fun updatePlayer(){
        player?.let {
            updatePlayer(player!!)
        }
    }
    fun response(string: String): Boolean {
        Log.d("word1", removeAccents(string))
        Log.d("word2", removeAccents(wordsGame[indexWord].name))
        return if (removeAccents(string).equals(
                removeAccents(wordsGame[indexWord].name),
                ignoreCase = true
            )
        ) {
            indexWord++
            score += 10
            corrects += 1
            true
        } else {
            indexWord++
            score -= 5
            incorrects += 1
            false
        }
    }
    fun finishGame(): Boolean = indexWord == wordsGame.size
    fun getAllIdLetters(activity: AppCompatActivity): List<RelativeLayout> = listOf(
            activity.findViewById(R.id.LetterA),
            activity.findViewById(R.id.LetterB),
            activity.findViewById(R.id.LetterC),
            activity.findViewById(R.id.LetterD),
            activity.findViewById(R.id.LetterE),
            activity.findViewById(R.id.LetterF),
            activity.findViewById(R.id.LetterG),
            activity.findViewById(R.id.LetterH),
            activity.findViewById(R.id.LetterI),
            activity.findViewById(R.id.LetterJ),
            activity.findViewById(R.id.LetterK),
            activity.findViewById(R.id.LetterL),
            activity.findViewById(R.id.LetterM),
            activity.findViewById(R.id.LetterN),
            activity.findViewById(R.id.LetterO),
            activity.findViewById(R.id.LetterP),
            activity.findViewById(R.id.LetterQ),
            activity.findViewById(R.id.LetterR),
            activity.findViewById(R.id.LetterS),
            activity.findViewById(R.id.LetterT),
            activity.findViewById(R.id.LetterU),
            activity.findViewById(R.id.LetterV),
            activity.findViewById(R.id.LetterX),
            activity.findViewById(R.id.LetterY),
            activity.findViewById(R.id.LetterZ),
        )
    //End Game functions


    //Databases functions:
    fun getAllWords(): List<WordEntity> {
        return runBlocking {
            var words: List<WordEntity> = arrayListOf()
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Search words init")
                words = database.wordDao().getAllWords()
                Log.d("GM", "search words end")
            }
            job.join()
            return@runBlocking words
        }
    }
    fun getAllPlayers(): List<PlayerEntity> {
        return runBlocking {
            var players: List<PlayerEntity> = arrayListOf()
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Search players init")
                players = database.playerDao().getAllPlayers()
                Log.d("GM", "Search players end")
            }
            job.join()
            return@runBlocking players
        }
    }
    fun searchWord(name: String):WordEntity?{
        return runBlocking {
            var word: WordEntity? = null
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Search word init")
                word = database.wordDao().getWord(name)
                Log.d("GM", "search word end")
            }
            job.join()
            return@runBlocking word
        }
    }
    fun searchPlayer(name: String): PlayerEntity? {
        return runBlocking {
            var player: PlayerEntity? = null
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Search player init")
                player = database.playerDao().getPlayerByName(name)
                Log.d("GM", "search player end")
            }
            job.join()
            return@runBlocking player
        }
    }
    fun addPlayer(newPlayer: PlayerEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Add player init")
                database.playerDao().insertPlayer(newPlayer)
                Log.d("GM", "Add player end")
            }
            job.join()
        }
    }
    fun addWord(newWord: WordEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Add word init")
                database.wordDao().insertWord(newWord)
                Log.d("GM", "Add word end")
            }
            job.join()
        }
    }
    private fun updatePlayer(player: PlayerEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Update player init")
                database.playerDao().updatePlayer(player)
                Log.d("GM", "Update player end")
            }
            job.join()
        }
    }
    fun updateWord(word: WordEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Upadate word init")
                database.wordDao().updateWord(word)
                Log.d("GM", "Update word end")
            }
            job.join()
        }
    }
    fun deletePlayer(player: PlayerEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Delete player init")
                database.playerDao().deletePlayer(player)
                Log.d("GM", "Delete player end")
            }
            job.join()
        }
    }
    fun deleteWord(word: WordEntity) {
        return runBlocking {
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "Delete word init")
                database.wordDao().deleteWord(word)
                Log.d("GM", "Delete word end")
            }
            job.join()
        }
    }
    //End database functions

}