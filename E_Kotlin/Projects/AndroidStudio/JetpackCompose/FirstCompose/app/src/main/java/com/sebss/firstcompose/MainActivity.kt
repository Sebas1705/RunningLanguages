package com.sebss.firstcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ViewContainer() {
    Scaffold(
        content = {Content()},
        topBar = { Toolbar() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "App sebas", fontSize = 30.sp, color = Color.White) },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.DarkGray
        ),

    )
}

@Composable
fun Content() {
    var counter by rememberSaveable { mutableStateOf(1) }

    LazyColumn(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(top = 80.dp)
            .fillMaxSize()
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "H"
            )
            Row(
                modifier = Modifier.padding(20.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_favorite_border_24),
                    contentDescription = "LIKE ICON",
                    modifier = Modifier.clickable {
                        counter++
                    })
                Text(
                    text = "$counter", fontSize = 20.sp, color = Color.White
                )
            }
            Text(
                text = "Sebas63xd",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 36.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(80.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
            ) {
                item {
                    Text(
                        text = "Sebas",
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(0.5f),
                        fontSize = 36.sp,
                        color = Color.White
                    )
                }
                item {
                    Text(
                        text = "Weee",
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(0.5f),
                        fontSize = 36.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}