package com.example.quizgame.quizgame

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quizgame.R
import com.example.quizgame.activities.ThirdActivity
import com.example.quizgame.fragments.ErrorFragment
import com.example.quizgame.fragments.FromImageFragment
import com.example.quizgame.fragments.ImageFragment
import com.example.quizgame.fragments.TextFragment
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.data.entities.PlayerEntity
import com.example.quizgame.data.entities.QFromImageEntity
import com.example.quizgame.data.entities.QImageEntity
import com.example.quizgame.data.entities.QTextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Game private constructor(private val database: AppDatabase) {

    //Game variables:
    private var score = 0
    private var nAsks = 5
    private var questions: MutableList<Question> = mutableListOf()
    private var category: Categories = Categories.ALL
    private var nLives = 4
    private var mediaPlayer: MediaPlayer? = null
    private var isMusicPlaying: Boolean = false
    private var loggedPlayer: PlayerEntity? = null

    // Constructor -Singleton-
    companion object {
        private var instance: Game? = null
        fun getInstance(database: AppDatabase): Game {
            if (instance == null) {
                instance = Game(database)
            }
            return instance!!
        }
    }

    //Questions functions:
    fun generateQuestions() {
        this.questions.clear()
        Log.d("Tempo", "For generate questions")
        val filterQuestions : List<Question> = when (this.category) {
            Categories.SCIENCE -> getTypeQuestions("Science")
            Categories.SPORTS -> getTypeQuestions("Sports")
            Categories.HISTORY -> getTypeQuestions("History")
            Categories.SERIES -> getTypeQuestions("Series")
            Categories.HARD -> getTypeQuestions("Hard")
            else -> getAllQuestions()
        }

        Log.d("Tempo", "Post generate questions")
        fullQuestions(filterQuestions)
    }
    private fun fullQuestions(listQuestion:List<Question>){
        Log.d("Tempo", "For full questions")
        var quest: Question
        var i = 0
        if (this.category == Categories.SURVIVAL) {
            // En el modo supervivencia, agrega todas las preguntas disponibles
            this.questions.addAll(listQuestion)
            return
        }
        while (i < nAsks) {
            quest = listQuestion.random()
            if (!this.questions.contains(quest)) {
                this.questions.add(quest)
                i++
            }
        }
        Log.d("Tempo", "Post full questions")
    }

    // Auxiliary methods:
    fun updateHeartLayout(activity: AppCompatActivity) {
        val livesText = activity.findViewById<TextView>(R.id.lives)
        val heart1Image = activity.findViewById<ImageView>(R.id.heart0)
        val heart2Image = activity.findViewById<ImageView>(R.id.heart1)
        val heart3Image = activity.findViewById<ImageView>(R.id.heart2)
        if(this.category==Categories.SURVIVAL) {
            //Set visibility of hearts to true
            livesText.visibility = View.VISIBLE
            //Heart1:
            if (nLives >= 2) heart1Image.setImageResource(R.drawable.heart)
            else  heart1Image.setImageResource(R.drawable.broke_heart)
            heart1Image.visibility=View.VISIBLE
            //Heart2:
            if (nLives >= 3) heart2Image.setImageResource(R.drawable.heart)
            else heart2Image.setImageResource(R.drawable.broke_heart)
            heart2Image.visibility=View.VISIBLE
            //Heart3:
            if (nLives == 4) heart3Image.setImageResource(R.drawable.heart)
            else heart3Image.setImageResource(R.drawable.broke_heart)
            heart3Image.visibility=View.VISIBLE
        }else{
            livesText.visibility = View.GONE
            heart1Image.visibility=View.GONE
            heart2Image.visibility=View.GONE
            heart3Image.visibility=View.GONE
        }
    }
    fun generateRandomQuestionFragment(activity: AppCompatActivity): Fragment {
        Log.d("GF", "GENERATE FRAG INIT")
        val question = questions.random()
        var fragment: Fragment = ErrorFragment("[ERROR] - No se ha encontrado pregunta")
        Log.d("GF", "GENERATE FRAG INIT")
        when (question) {
            is QTextEntity -> fragment = TextFragment(question, activity)
            is QImageEntity -> fragment = ImageFragment(question, activity)
            is QFromImageEntity -> fragment = FromImageFragment(question, activity)
        }
        Log.d("GF", "GENERATE FRAG END")
        return fragment
    }
    fun replyQuestion(
        question: Question,
        option: Int,
        activity: AppCompatActivity
    ) {
        val pointText = activity.findViewById<TextView>(R.id.point_text)
        //Correct or incorrect answer
        if(question.correctAnswer==option){
            this.score += 3
            Toast.makeText(activity,"Bien hecho +3! Score: ${this.score}",Toast.LENGTH_SHORT).show()
            SoundPlayer(activity).playSound(R.raw.whoho)
        }else{
            this.score -= 2
            if(this.category==Categories.SURVIVAL){
                nLives--
                updateHeartLayout(activity)
                if (nLives <= 0) {
                    Toast.makeText(
                        activity,
                        "¡Perdiste todas tus vidas! Juego terminado",
                        Toast.LENGTH_SHORT
                    ).show()
                    changeActivity(activity, ThirdActivity::class.java, true)
                } else Toast.makeText(
                    activity,
                    "Uf casi -2! Score: ${this.score}",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(activity, "Uf casi -2! Score: ${this.score}", Toast.LENGTH_SHORT).show()
                SoundPlayer(activity).playSound(R.raw.tuberia)
            }
        }
        pointText.text = activity.getString(R.string.points_bargame,score.toString())
        this.questions.remove(question)
        //Update game variables to next fragment
        if(this.category==Categories.SURVIVAL){
            if (questions.isEmpty()) changeActivity(activity,ThirdActivity::class.java,true)
            else if (nLives == 0) {
                if(loggedPlayer?.score!! <score) loggedPlayer!!.score = score
                updatePlayer(loggedPlayer!!)
                changeActivity(activity,ThirdActivity::class.java,true)
            } else changeFragment(activity)
        }else{
            nAsks--
            if(nAsks==0){
                nAsks=5
                changeActivity(activity,ThirdActivity::class.java,true)
            }else changeFragment(activity)
        }
    }
    fun startBackgroundMusic(context: Context) {
        if (!isMusicPlaying) {
            mediaPlayer = MediaPlayer.create(context, R.raw.castle)
            mediaPlayer?.isLooping = true
            mediaPlayer?.start()
            isMusicPlaying = true
        }
    }
    fun stopBackgroundMusic() {
        if (isMusicPlaying) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
            isMusicPlaying = false
        }
    }
    fun logInPlayer(player: PlayerEntity){
        loggedPlayer = player
    }
    fun logOutPlayer(){
        loggedPlayer = null
    }
    fun changeActivity(activity: AppCompatActivity,cls: Class<out AppCompatActivity>,clearOfTop: Boolean,animStart: Int = R.anim.zoom_in, animEnd: Int = R.anim.zoom_out ){
        val intent = Intent(activity,cls)
        if(clearOfTop)intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val options = ActivityOptionsCompat.makeCustomAnimation(activity, animStart, animEnd)
        ActivityCompat.startActivity(activity, intent, options.toBundle())
    }
    fun resetScore() {
        this.score = 0
        this.nLives = 4
    }

    //Databases functions:
    fun searchPlayer(name: String): PlayerEntity?{
        return runBlocking{
            var player: PlayerEntity? = null
            val job = CoroutineScope(Dispatchers.IO).launch{
                Log.d("GM", "Search player init")
                player = database.playerDao().searchPlayerByName(name)
                Log.d("GM", "search player end")
            }
            job.join()
            return@runBlocking player
        }
    }
    fun addPlayer(newPlayer: PlayerEntity){
        return runBlocking{
            val job = CoroutineScope(Dispatchers.IO).launch{
                Log.d("GM", "Add player init")
                database.playerDao().insertPlayer(newPlayer)
                Log.d("GM", "Add player end")
            }
            job.join()
        }
    }
    fun deletePlayer(player: PlayerEntity){
        return runBlocking{
            val job = CoroutineScope(Dispatchers.IO).launch{
                Log.d("GM", "Delete player init")
                database.playerDao().deletePlayer(player)
                Log.d("GM", "Delete player end")
            }
            job.join()
        }
    }
    fun getRanking():String{
        val listPlayers : MutableList<PlayerEntity> = mutableListOf()
        runBlocking{
            val job = CoroutineScope(Dispatchers.IO).launch{
                Log.d("GM", "Ranking player init")
                database.playerDao().getAllPlayers().first().forEach{listPlayers.add(it)}
                Log.d("GM", "Ranking player end")
            }
            job.join()
        }
        var ranking = ""
        var i = 1
        listPlayers.forEach {
            val playerName = if (it.name == loggedPlayer?.name) ">${it.name}<" else it.name
            ranking += "\n${i++}º           $playerName:${it.score}"
        }
        return ranking
    }

    //Get methods:
    fun getScore(): Int {
        return this.score
    }
    fun getCategory(): Categories {
        return this.category
    }
    fun getLoggedPlayer(): PlayerEntity?{
        return this.loggedPlayer
    }

    //Set methods:
    fun setCategory(category: Categories) {
        this.category = category
    }

    //Private methods:
    private fun getTypeQuestions(type:String): List<Question> {
        return runBlocking {
            val listQuestion: MutableList<Question> = mutableListOf()
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "GENERATE TYPEQUESTIONS INIT")
                database.qFromImageDao().getAllTypedQFromImage(type).forEach { listQuestion.add(it) }
                database.qImageDao().getAllTypedQImage(type).forEach { listQuestion.add(it) }
                database.qTextDao().getAllTypedQText(type).forEach { listQuestion.add(it) }
                Log.d("GM", "GENERATE TYPEQUESTIONS END")
            }
            job.join()
            return@runBlocking listQuestion.toList()
        }
    }
    private fun getAllQuestions(): List<Question> {
        return runBlocking{
            val listQuestion: MutableList<Question> = mutableListOf()
            val job = CoroutineScope(Dispatchers.IO).launch {
                Log.d("GM", "GENERATE ALLQUESTIONS INIT")
                database.qTextDao().getAllQText().forEach { listQuestion.add(it) }
                if (category != Categories.HARD){
                    database.qFromImageDao().getAllQFromImage().forEach { listQuestion.add(it) }
                    database.qImageDao().getAllQImage().forEach { listQuestion.add(it) }
                }
                Log.d("GM", "GENERATE ALLQUESTIONS END")
            }
            job.join()
            return@runBlocking listQuestion.toList()
        }
    }
    private fun updatePlayer(player: PlayerEntity) {
        return runBlocking{
            val job = CoroutineScope(Dispatchers.IO).launch{
                Log.d("GM", "UPDATE PLAYER INIT")
                database.playerDao().updatePlayer(player)
                Log.d("GM", "UPDATE PLAYER END")
            }
            job.join()
        }
    }
    private fun changeFragment(activity: AppCompatActivity){
        val fragmentSupport = activity.supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.translate_left,R.anim.zoom_out)
        fragmentSupport.replace(R.id.containerQuestions, generateRandomQuestionFragment(activity)).commit()
    }

}