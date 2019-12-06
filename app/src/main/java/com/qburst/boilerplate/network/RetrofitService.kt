package com.qburst.boilerplate.network

import com.qburst.boilerplate.models.Response
import com.qburst.boilerplate.models.ResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/*
Contains endpoints to the REST API
 */

interface RetrofitService{
    @GET("posts")
    fun getAllListings(): Call<ResponseList>

    @GET("posts")
    fun getListingInfo(@Query("id") id: Int): Call<Response>
}