package com.vesam.barexamlibrary.utils.build_config


class BuildConfig {
    companion object {
        var BASE_URL = ""
        var BASE_URL_IMAGE_AND_VIDEO_VALUE = ""

        // header
        const val CONTENT_TYPE_HEADER = "Content-Type"
        const val APPLICATION_JSON_HEADER = "application/json"
        const val AUTHORIZATION = "Authorization"
        const val BEARER = "Bearer "

        // header
        const val USER_UUID = "user_uuid"
        const val USER_API_TOKEN = "user_api_token"

        // header value
        var USER_UUID_VALUE = ""
        var USER_API_TOKEN_VALUE = ""
        var USER_QUIZ_ID_VALUE = -1

        // slider
        var DELAYED_SLIDER = 5000L

    }
}