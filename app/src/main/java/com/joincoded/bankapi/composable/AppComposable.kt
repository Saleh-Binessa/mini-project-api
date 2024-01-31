package com.joincoded.bankapi.composable


import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.data.Navigation.Screen







@Composable
fun BankApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Signup.route) {
        composable(Screen.Signup.route) {
            SignUpScreen(
                onSignInClick = { navController.navigate(Screen.Signin.route) },
                onSignUpClick = { username, password, image ->

                    navController.navigate(Screen.Signin.route)
                }
            )
        }
        composable(Screen.Signin.route) {
            SignInScreen(
                onSignInClick = { username, password ->

                },
                onSignUpClick = { navController.navigate(Screen.Signup.route) }
            )
        }
    }
}

