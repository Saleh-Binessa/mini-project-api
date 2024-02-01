package com.joincoded.bankapi.composable.Signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.viewmodel.BankViewModel


@Composable
fun SignUpForm( bankViewModel: BankViewModel ,onSigninClick:() -> Unit


) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = image,
            onValueChange = { image = it },
            label = { Text("Image URL") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { bankViewModel.signup(username, password, image,onSigninClick) },
            modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
        ) {
            Text(text = "Sign Up")
        }
    }
}
