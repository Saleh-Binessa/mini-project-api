package com.joincoded.bankapi.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.viewmodel.BankViewModel


@Composable
fun SignUpScreen(
    onSignInClick: () -> Unit,
onSignUpClick: (String, String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = "Bank App", style = MaterialTheme.typography.headlineMedium,color =  Color(0xFF9AD14D))


        Spacer(modifier = Modifier.height(16.dp))
        SignUpForm( viewModel = BankViewModel())

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onSignInClick) {
            Text(text = "Already have an account? Sign In")
        }
    }
}