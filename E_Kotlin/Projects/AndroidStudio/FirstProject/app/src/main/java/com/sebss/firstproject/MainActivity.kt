package com.sebss.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart(){
        super.onStart()
        Log.i("START","Method onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.i("RESUME","Method onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("PAUSE","Method onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("STOP","Method onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("DESTROY","Method onDestroy")
    }
}