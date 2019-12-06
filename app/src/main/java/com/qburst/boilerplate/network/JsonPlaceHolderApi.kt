package com.qburst.boilerplate.network

import com.qburst.boilerplate.data.Result
import com.qburst.boilerplate.models.ApiResult
import com.qburst.boilerplate.models.Failure
import com.qburst.boilerplate.models.Success
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

object JsonPlaceHolderApi {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val retrofitService: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    fun getAllListings() = retrofitService.getAllListings().callWithExceptionHandling()

    fun getListingInfo(id: Int) = retrofitService.getListingInfo(id).callWithExceptionHandling()
}

private fun <T: Any> Call<T>.callWithExceptionHandling(): ApiResult<T> {
    var responseCode = 101
    var responseMsg = "Unknown error"

    return try {
        val response = execute()

        if(response.isSuccessful && response.body()!=null){

            Success(response.body() as T)

        }else{
            responseCode = response.code()
            responseMsg = response.message()
            Failure(responseCode)
        }
    }catch(e:Exception) {
        //Handle Exception Here
        Failure(101)

    }


}