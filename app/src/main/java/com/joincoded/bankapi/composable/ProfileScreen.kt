package com.joincoded.bankapi.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.joincoded.bankapi.viewmodel.BankViewModel

@Composable
fun ProfileScreen(viewModel: BankViewModel) {
    var username by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf("") }

    Column {
            Text(text = "Profile")
        OutlinedTextField(
            value = username,
            onValueChange = { username = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = image,
            onValueChange = { image = it },
            label = { Text("image") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = balance,
            onValueChange = { balance = it },
            label = { Text("balance") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

    }
}