

package com.amrh.data.competitions.remote

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val exception: Throwable? = null) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

fun <T> Flow<T>.flowAsResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart { emit(Result.Loading) }
        .catch {
            Log.e("TAG", "flowAsResult: ${it.localizedMessage}", )
            emit(Result.Failure(it))

        }
}
