package com.joincoded.bankapi.data

data class TransactionDetails(
    var amount:Double,
    var transactiontype:String,
    var senderId:Int,
    var reciverId:Int


)
