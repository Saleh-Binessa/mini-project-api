package com.joincoded.bankapi.composable.Wallet

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankapi.data.TransactionDetails
import com.joincoded.bankapi.viewmodel.BankViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WalletPage(bankViewModel: BankViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header with Wallet icon and balance
        WalletHeader(bankViewModel)

        // Divider
        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Transactions
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(bankViewModel.transactions ?: emptyList()) { transactionDetails ->
                TransactionItem(bankViewModel, transactionDetails)
            }
        }
        @Composable
        fun WalletPage(bankViewModel: BankViewModel) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Header with Wallet icon and balance
                WalletHeader(bankViewModel)

                // Divider
                Divider(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )

                // Transactions
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    items(bankViewModel.transactions ?: emptyList()) { transactionDetails ->
                        TransactionItem(bankViewModel, transactionDetails)
                    }
                }

            }
        }
    }
    }


@Composable
fun WalletHeader(bankViewModel: BankViewModel) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Outlined.AccountBox,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.height(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Balance: ${bankViewModel.user?.balance ?: 0.0} USD",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun TransactionItem(viewModel: BankViewModel, transaction: TransactionDetails) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = if (transaction.amount > 0) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = if (transaction.amount > 0) Color.Green else Color.Red,
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "${transaction.amount} $",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date()),
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}