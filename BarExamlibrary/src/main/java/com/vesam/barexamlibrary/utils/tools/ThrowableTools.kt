package com.vesam.barexamlibrary.utils.tools

import com.google.gson.Gson
import com.vesam.barexamlibrary.R
import com.vesam.barexamlibrary.utils.application.AppQuiz
import retrofit2.HttpException
import java.net.SocketTimeoutException


class ThrowableTools(private val networkTools: NetworkTools,private val gson: Gson) {

    fun getThrowableError(throwable: Throwable): String {
        return initResultException(throwable)
    }

    private fun initResultException(throwable: Throwable): String {
        return when {
            networkTools.isNetworkAvailable -> AppQuiz.context.getString(R.string.no_connection)
            throwable is HttpException -> initHttpException(throwable)
            throwable is SocketTimeoutException -> AppQuiz.context.getString(R.string.time_out)
            else -> throwable.message.toString()
        }
    }

    private fun initHttpException(throwable: Throwable): String {
        return throwable.message!!
    }
}