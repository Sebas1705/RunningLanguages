package com.sebss.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sebss.firstcompose.ui.screens.LoginScreen
import com.sebss.firstcompose.ui.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(LoginViewModel())
        }
    }
}

