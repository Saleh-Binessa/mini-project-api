package com.joincoded.bankapi.network

import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.TransactionDetails
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BankApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.signinEndpoint)
    suspend fun signin(@Body user: User): Response<TokenResponse>

    @PUT(Constants.depositEndpoint)
    suspend fun deposit(
        @Header(Constants.authorization) token: String?,
        @Body amountChange: AmountChange
    ): Response<Unit>

    @PUT(Constants.withdrawEndpoint)
    suspend fun withdraw(
        @Header(Constants.authorization) token: String?,
        @Body amountChange: AmountChange
    ): Response<Unit>
    @GET(Constants.showProfileEndpoint)
    suspend fun showProfile(@Header(Constants.authorization) token: String?): Response<User>
    @PUT(Constants.updateProfileEndpoints)
    suspend fun updateProfile(@Header(Constants.authorization) token: String?,
                              @Body user: User):Response<Unit>

    @GET(Constants.transactionsEndpoint)
    suspend fun Transactions(@Header(Constants.authorization) token: String?):Response<List<TransactionDetails>>
    @POST("${Constants.transferEndpoint}/{userName}")
    suspend fun transfer(@Path("userName") userName: String,
                         @Header(Constants.authorization) token: String?,
                         @Body amountChange: AmountChange): Response<Unit>

}