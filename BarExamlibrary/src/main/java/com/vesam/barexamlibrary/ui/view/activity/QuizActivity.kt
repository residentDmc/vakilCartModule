package com.vesam.barexamlibrary.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.vesam.barexamlibrary.databinding.ActivityQuizBinding
import com.vesam.barexamlibrary.utils.base.BaseActivity

class QuizActivity : BaseActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeepLink(intent)
    }

    private fun handleDeepLink(intent: Intent?) {
        val date = intent?.data
        date?.let { resultData ->
            Log.d("TAG", "handleDeepLink: $resultData")
        }
    }
}