package com.joincoded.bankapi.composable.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.joincoded.bankapi.viewmodel.BankViewModel

@Composable
fun ProfileForm(bankViewModel: BankViewModel) {
    var username by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = com.joincoded.bankapi.ui.theme.Green_TAM),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),

        ) {
//        Text(text = "Profile")
                Text(text = "Username: " + bankViewModel.user?.username, fontSize = 16.sp)

        Row(
            Modifier
                .padding(10.dp)
                .height(800.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Column(
                Modifier
                    .padding(10.dp)
            ) {
                Text(text = "" + image, fontSize = 16.sp)
                Text(
                    text = "Balance:\t\t\t\t\t" + balance.toString(),
                    fontSize = 16.sp
                )
            }
        }
    }
}