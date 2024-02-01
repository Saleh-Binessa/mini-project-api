package com.joincoded.bankapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.TransactionDetails
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.BankApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.launch

class BankViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BankApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)
    var user: User? by mutableStateOf(null)
    var transactions: List<TransactionDetails>? by mutableStateOf(null)

    fun signup(username: String, password: String, image: String = "",navigation: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, null, "", null))
                token = response.body()
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                if (token!=null)
                {
                    showProfile()
                   // Transactions()
                    navigation()
                }
            }

        }
    }
    fun signin(username: String,password: String){
        viewModelScope.launch {
            try {
                val response = apiService.signin(User(username, password, null, "", null))
                token = response.body()
                println("TOKEN SIGNIN ${token?.token}")
                transactions()
                showProfile()
                


            } catch (e: Exception) {
                println("Error $e")
            }
        }

    }

    fun showProfile() {
        viewModelScope.launch {
            try {
                val response = apiService.showProfile(token = token?.getBearerToken())
                user = response.body()
            } catch (e: Exception) {
                println("Error $e")
            }
        }

    }

    fun deposit(amount: Double) {
        viewModelScope.launch {
            try {
                val response = apiService.deposit(
                    token = token?.getBearerToken(),
                    AmountChange(amount)
                )
                if (response.isSuccessful) {
                    println("Deposit Successful")
                } else {
                    println("Deposit Failed")
                }
            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }
    fun withdraw(amount: Double) {
        viewModelScope.launch {
            try {
                val response = apiService.withdraw(
                    token = token?.getBearerToken(),
                    AmountChange(amount)
                )
                if (response.isSuccessful) {
                    println("Withdraw Successful")
                } else {
                    println("Withdraw Failed")
                }
            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }
    fun transfer(username: String, amount: Double) {
        viewModelScope.launch {
            try {
                val response = apiService.transfer(
                    userName = username,
                    token = token?.getBearerToken(),
                    amountChange = AmountChange(amount)
                )
                if (response.isSuccessful) {

                    println("Successful transfer")
                } else {

                    println("Failed transfer")
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }
    fun updateProfile(username: String,password: String){
        viewModelScope.launch {
            try {
                val response = apiService.updateProfile(token = token?.getBearerToken(),
                    user = User(username, password, null, "", null,))
            } catch (e: Exception){
                println("Error $e")
            }


        }
    }
   fun transactions(){
        viewModelScope.launch {
            try {
                val response = apiService.Transactions(token = token?.getBearerToken())
                transactions = response.body()
            } catch (e:Exception){
                println("Error $e")
            }

        }
    }
}
