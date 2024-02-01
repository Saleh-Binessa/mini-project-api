package com.joincoded.bankapi.composable.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.joincoded.bankapi.composable.Signin.SignInForm
import com.joincoded.bankapi.composable.Wallet.InputField
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.viewmodel.BankViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(bankViewModel: BankViewModel = viewModel(), toDetails: () -> Unit) {


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Update profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        InputField(
            value = username,
            onValueChange = { username = it },
            label = "UserName"
        )
        InputField(
            value = password,
            onValueChange = { password = it },
            label = "Password"
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(username.length > 0 && password.length > 0)
                    bankViewModel.updateProfile(username = username, password = password, toDetails)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update")
        }
    }
}

