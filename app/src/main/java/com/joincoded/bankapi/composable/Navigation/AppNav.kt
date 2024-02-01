package com.joincoded.bankapi.composable.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.composable.Signin.SignInScreen
import com.joincoded.bankapi.composable.Signup.SignUpScreen

import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.viewmodel.BankViewModel


@Composable
fun AppNav() {
    val navController: NavHostController = rememberNavController()
    val bankViewModel: BankViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.signupRoute) {
        composable(Routes.signupRoute) {
            SignUpScreen(
                bankViewModel = bankViewModel,
                onSignInClick = { navController.navigate(Routes.signinRoute) },

            )
        }
        composable(Routes.signinRoute) {
            SignInScreen(
               bankViewModel=bankViewModel,
                onSignUpClick = {
                    navController.navigate(Routes.signupRoute)
                },
                navigateToHome =  {
                    navController.navigate(Routes.homeRoute)
                }
            )
        }

        composable(Routes.homeRoute) {
            AppFrontPage()
        }


    }
}

