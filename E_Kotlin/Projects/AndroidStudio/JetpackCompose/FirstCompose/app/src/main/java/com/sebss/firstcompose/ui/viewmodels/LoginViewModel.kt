package com.sebss.firstcompose.ui.viewmodels

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun onLoginChanged(email:String,password:String){
        _email.value=email
        _password.value=password
        _loginEnable.value=isValidEmail(email)&&isValidPassword(password)
    }

    fun onLoginSelected(context:Context){
        viewModelScope.launch{
            _isLoading.value=true
            delay(1000)
            _isLoading.value=false
            Toast.makeText(context,"Logeo", Toast.LENGTH_LONG).show()
        }
    }

    private fun isValidEmail(email:String):Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length >= 10
}