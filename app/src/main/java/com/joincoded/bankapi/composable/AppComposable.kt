package com.joincoded.bankapi.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.data.Navigation.Screen
import com.joincoded.bankapi.viewmodel.BankViewModel






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

