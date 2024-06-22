package com.sebss.firstcompose.ui.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.*
import com.sebss.firstcompose.R
import com.sebss.firstcompose.ui.viewmodels.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center),viewModel)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {
    val email:String by viewModel.email.observeAsState(initial="")
    val password:String by viewModel.password.observeAsState(initial="")
    val loginEnable:Boolean by viewModel.loginEnable.observeAsState(initial=false)
    val isLoading:Boolean by viewModel.isLoading.observeAsState(initial=false)
    val context = LocalContext.current

    if(!isLoading) Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email) { viewModel.onLoginChanged(it,password) }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password) { viewModel.onLoginChanged(email,it) }
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(loginEnable) { viewModel.onLoginSelected(context) }
    }
    else Box(modifier=Modifier.fillMaxSize()){
        CircularProgressIndicator(modifier=Modifier.align(Alignment.Center))
    }

}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: ()->Unit) {
    Button(
        onClick = onLoginSelected,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A66E9),
            disabledContainerColor = Color(0xFF58B2F7),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        enabled = loginEnable
    ) {
        Text(text = "Inicia Sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidastes la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Cyan
    )
}

@Composable
fun PasswordField(password: String, onValueChanged: (String) -> Unit) {
    val containerColor = Color(0xFFDEDDDD)
    TextField(
        value = password,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF636262),
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}


@Composable
fun EmailField(email: String,onValueChanged:(String)->Unit) {
    val containerColor = Color(0xFFDEDDDD)
    TextField(
        value = email,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF636262),
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.foto),
        contentDescription = "Logo",
        modifier = modifier
    )
}
