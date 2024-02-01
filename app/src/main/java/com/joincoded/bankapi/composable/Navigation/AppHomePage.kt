package com.joincoded.bankapi.composable.Navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.joincoded.bankapi.composable.ProfileScreen

import com.joincoded.bankapi.composable.Wallet.WalletPage
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.viewmodel.BankViewModel

@Composable
fun AppFrontPage(bankViewModel: BankViewModel= viewModel(),) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar( modifier = Modifier, Color.DarkGray) {
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.walletRoute)
            }, icon = {
                Text(text = "Wallet")
            })
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.profileRoute)
            }, icon = {
                Icon(Icons.Filled.AccountBox ,contentDescription = "Profile")
            })
        }
    }) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Routes.walletRoute
        ) {

            composable(Routes.walletRoute) {
                WalletPage(bankViewModel)
            }

            composable(Routes.profileRoute) {
                ProfileScreen(
                    viewModel()
                )
            }
        }
    }

}

@Composable
fun ProfilePage() {
    // Implement the UI for the Profile page here
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Page")
    }
}

