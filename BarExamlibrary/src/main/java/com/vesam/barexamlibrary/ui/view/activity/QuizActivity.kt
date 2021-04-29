package com.vesam.barexamlibrary.ui.view.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.vesam.barexamlibrary.R
import com.vesam.barexamlibrary.databinding.ActivityQuizBinding
import com.vesam.barexamlibrary.utils.base.BaseActivity
import com.vesam.barexamlibrary.utils.option.Option.Companion.BUNDLE_BASE_URL_IMAGE_AND_VIDEO_VALUE
import com.vesam.barexamlibrary.utils.option.Option.Companion.BUNDLE_BASE_URL_VALUE
import com.vesam.barexamlibrary.utils.option.Option.Companion.BUNDLE_QUIZ_ID_VALUE
import com.vesam.barexamlibrary.utils.option.Option.Companion.BUNDLE_USER_API_TOKEN_VALUE
import com.vesam.barexamlibrary.utils.option.Option.Companion.BUNDLE_USER_UUID_VALUE
import com.vesam.barexamlibrary.utils.tools.ToastTools
import com.vesam.barexamlibrary.utils.application.AppQuiz
import com.vesam.barexamlibrary.utils.build_config.BuildConfig.Companion.BASE_URL
import com.vesam.barexamlibrary.utils.build_config.BuildConfig.Companion.BASE_URL_IMAGE_AND_VIDEO_VALUE
import com.vesam.barexamlibrary.utils.build_config.BuildConfig.Companion.USER_API_TOKEN_VALUE
import com.vesam.barexamlibrary.utils.build_config.BuildConfig.Companion.USER_QUIZ_ID_VALUE
import com.vesam.barexamlibrary.utils.build_config.BuildConfig.Companion.USER_UUID_VALUE
import com.vesam.barexamlibrary.utils.tools.HandelErrorTools
import com.vesam.barexamlibrary.utils.tools.ThrowableTools
import org.koin.android.ext.android.inject

class QuizActivity : BaseActivity() {

    private lateinit var binding: ActivityQuizBinding
    private lateinit var navController: NavController
    private val toastTools: ToastTools by inject()
    private val throwableTools: ThrowableTools by inject()
    private val handelErrorTools: HandelErrorTools by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            initAction()
        } catch (e: Exception) {
            handelErrorTools.handelError(e)
        }
    }

    private fun initAction() {
        initBundle()
        initNavController()
    }

    private fun initBundle() {
        BASE_URL = intent.extras!!.getString(BUNDLE_BASE_URL_VALUE, "")
        BASE_URL_IMAGE_AND_VIDEO_VALUE = intent.extras!!.getString(
            BUNDLE_BASE_URL_IMAGE_AND_VIDEO_VALUE, ""
        )
        USER_API_TOKEN_VALUE = intent.extras!!.getString(BUNDLE_USER_API_TOKEN_VALUE, "")
        USER_UUID_VALUE = intent.extras!!.getString(BUNDLE_USER_UUID_VALUE, "")
        USER_QUIZ_ID_VALUE = intent.extras!!.getInt(BUNDLE_QUIZ_ID_VALUE, -1)
    }

    private fun initNavController() {
        navController = Navigation.findNavController(AppQuiz.activity, R.id.my_nav_fragment)
    }
}