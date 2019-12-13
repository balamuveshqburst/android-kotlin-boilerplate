package com.qburst.boilerplate.models

data class Response(val userId:Int, val id: Int, val title: String, val body: String)

data class ResponseList(val response: List<Response>)