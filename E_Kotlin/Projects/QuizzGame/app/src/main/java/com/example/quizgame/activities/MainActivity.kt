package com.example.quizgame.activities



import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.example.quizgame.quizgame.Categories
import com.example.quizgame.quizgame.Game
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase

class MainActivity : AppCompatActivity() {

    //Components:
    private lateinit var startButton: Button
    private lateinit var categoryButton: Button
    private lateinit var outplayButton : Button
    private lateinit var helpbutton: ImageButton
    private lateinit var toolbar: Toolbar
    private lateinit var textname: TextView
    private lateinit var ranking: TextView
    private val game: Game = Game.getInstance(AppDatabase.getInstance(this))
    private var mediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init with ids:
        startButton = findViewById(R.id.start_button)
        categoryButton = findViewById(R.id.selectCategory_button)
        helpbutton = findViewById(R.id.help_button)
        outplayButton = findViewById(R.id.outPlayer_button)
        textname = findViewById(R.id.text_name)
        toolbar = findViewById(R.id.toolbar)
        ranking = findViewById(R.id.ranking)

        //Uses of components:
        setSupportActionBar(toolbar)
        helpbutton.setOnClickListener { game.changeActivity(this,HelpActivity::class.java,true) }
        categoryButton.text = getString(R.string.Category_text, game.getCategory().name)
        textname.text = game.getLoggedPlayer()?.name ?: "Jugador no logeado!\n cierre y vuelva a abrir"
        textname.setBackgroundResource(R.drawable.transparent_background)
        ranking.text = getString(R.string.ranking_main,game.getRanking())
        startButton.setOnClickListener {
            playSound()
            game.resetScore()
            game.generateQuestions()
            Log.d("Tempo", "Apunto cambio de intent al second")
            game.changeActivity(this,SecondActivity::class.java,false)
        }
        categoryButton.setOnClickListener {
            showCategoriesWindow()
            playSound()
        }
        outplayButton.setOnClickListener {
            game.logOutPlayer()
            game.changeActivity(this,PlayersSelectActivity::class.java,false)
        }
    }
    override fun onDestroy() {
        //Free resources
        mediaPlayer?.release()
        super.onDestroy()
    }

    //Private methods:
    private fun playSound() {
        //Free resources
        mediaPlayer?.release()
        //Create new media player with raw
        mediaPlayer = MediaPlayer.create(this, R.raw.mario)
        //Start music
        mediaPlayer?.start()
    }
    private fun showCategoriesWindow() {
        // Create popup
        val popUpView = layoutInflater.inflate(R.layout.select_category_popup, null)
        val radioGroup = popUpView.findViewById<RadioGroup>(R.id.categoryRadioGroup)
        val popUp = AlertDialog.Builder(this).setView(popUpView).create()

        // Create radio buttons confirmation:
        val confirmButton = popUpView.findViewById<Button>(R.id.confirmCategoryButton)
        confirmButton.setOnClickListener {
            playSound()
            when (radioGroup.checkedRadioButtonId) {
                R.id.scienceOption -> game.setCategory(Categories.SCIENCE)
                R.id.historyOption -> game.setCategory(Categories.HISTORY)
                R.id.tvOption -> game.setCategory(Categories.SERIES)
                R.id.sportsOption -> game.setCategory(Categories.SPORTS)
                R.id.hardOption -> game.setCategory(Categories.HARD)
                R.id.SURVIVAL -> game.setCategory(Categories.SURVIVAL)
                else -> game.setCategory(Categories.ALL)
            }
            // Set category name
            categoryButton.text = getString(R.string.Category_text, game.getCategory().name)
            // Close popup
            popUp.dismiss()
        }
        // Show popup
        popUp.show()
    }
}








