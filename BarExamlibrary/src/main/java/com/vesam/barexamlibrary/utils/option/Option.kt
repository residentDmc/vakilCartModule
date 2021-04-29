package com.vesam.barexamlibrary.utils.option

import android.app.Activity
import android.content.Intent
import com.vesam.barexamlibrary.ui.view.activity.QuizActivity

class Option{

    companion object{
        const val BUNDLE_BASE_URL_VALUE = "base_url"
        const val BUNDLE_BASE_URL_IMAGE_AND_VIDEO_VALUE = "base_url_image_and_video"
        const val BUNDLE_USER_UUID_VALUE = "user_uuid"
        const val BUNDLE_USER_API_TOKEN_VALUE = "user_api_token"
        const val BUNDLE_QUIZ_ID_VALUE = "quiz_api"
        @JvmStatic
        fun start(activity: Activity,
                  baseUrl: String,
                  baseUrlImageAndVideo: String,
                  token: String,
                  userId: String,
                  quizId: Int) {
            val intent = Intent()
            intent.putExtra(BUNDLE_BASE_URL_VALUE,baseUrl)
            intent.putExtra(BUNDLE_BASE_URL_IMAGE_AND_VIDEO_VALUE,baseUrlImageAndVideo)
            intent.putExtra(BUNDLE_USER_API_TOKEN_VALUE,token)
            intent.putExtra(BUNDLE_USER_UUID_VALUE,userId)
            intent.putExtra(BUNDLE_QUIZ_ID_VALUE,quizId)
            intent.setClass(activity, QuizActivity::class.java)
            activity.startActivity(intent)
        }
    }


}