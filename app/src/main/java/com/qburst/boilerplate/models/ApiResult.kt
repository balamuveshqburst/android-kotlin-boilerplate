package com.qburst.boilerplate.models

sealed class ApiResult<out T : Any>

data class Success<out T : Any>(val contents: T) : ApiResult<T>()

data class Failure(val errorCode: Int) : ApiResult<Nothing>()

