
package com.joincoded.bankapi.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.joincoded.bankapi.composable.Wallet.InputField
import com.joincoded.bankapi.viewmodel.BankViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DepositCompose(bankViewModel:BankViewModel= viewModel(),
                   deposit: () -> Unit

) {


    var amount by remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add your deposit amount",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            InputField(
                value = amount,
                onValueChange = { amount = it },
                label = "Deposit amount"
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {

                    bankViewModel.deposit(amount.toDouble(),deposit)

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(" Deposit ")
            }
        }
    }
}
