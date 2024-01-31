package com.joincoded.bankapi.data.Navigation

sealed class Screen (val route: String){
    object Signup:Screen("Signup")
    object Signin:Screen("Signin")
}