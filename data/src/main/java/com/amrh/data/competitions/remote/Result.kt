

package com.amrh.data.competitions.remote

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import retrofit2.HttpException


const val UNKNOWN_HOST_EXCEPTION = "UnknownHostException"
sealed class Res<out T> {
    data class Success<T>(val data: T) : Res<T>()
    data class Failure(val exception: Throwable? = null) : Res<Nothing>()
    data class UnAuthorized(val exception: Throwable? = null) : Res<Nothing>()

    object Loading : Res<Nothing>()
}

fun <T> Flow<T>.flowAsResult(): Flow<Res<T>> {
    return this
        .map<T, Res<T>> {
            Res.Success(it)
        }
        .onStart { emit(Res.Loading) }
        .catch {
            Log.e("TAG", "flowAsResult: ${it.localizedMessage}", )
            emit(Res.Failure(it))

        }
}


suspend fun <T> safeApiCall(apiCall: suspend () -> T): Res<T> {
    return try {
        Res.Success(apiCall())
    } catch (e: Exception) {
        if (isUnauthorizedOrForbiddenException(e)){Res.UnAuthorized(e)}else{Res.Failure(e)}
    }
}


fun isUnauthorizedOrForbiddenException(exception: Exception): Boolean {
    return when (exception) {
        is HttpException -> {
            val code = exception.code()
            code == 401 || code == 403
        }
        else -> false
    }
}

fun <T : Any?> handleErrorBody(throwable: Throwable, aclass: Class<T>): T? {
    return try {
        val error: HttpException = throwable as HttpException
        val jObj = error.response()?.errorBody()!!.string()
        val gson = Gson()
        gson.fromJson(jObj, aclass)

    } catch (e: Exception) {
        null
    }

}
