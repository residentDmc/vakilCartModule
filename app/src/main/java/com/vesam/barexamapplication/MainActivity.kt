package com.vesam.barexamapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.vesam.barexamlibrary.utils.option.Option

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tlBaseUrl=findViewById<TextInputLayout>(R.id.tlBaseUrl)
        val tlToken=findViewById<TextInputLayout>(R.id.tlToken)
        val tlBaseUrlImageAndVideo=findViewById<TextInputLayout>(R.id.tlBaseUrlImageAndVideo)
        val tlUserId=findViewById<TextInputLayout>(R.id.tlUserId)
        val tlQuizId=findViewById<TextInputLayout>(R.id.tlQuizId)
        val btnEnterExam=findViewById<MaterialButton>(R.id.btnEnterExam)
        btnEnterExam.setOnClickListener {
            val baseUrl = tlBaseUrl.editText!!.text.toString()
            val baseUrlImageAndVideo = tlBaseUrlImageAndVideo.editText!!.text.toString()
            val token = tlToken.editText!!.text.toString()
            val userId = tlUserId.editText!!.text.toString()
            val quizId = tlQuizId.editText!!.text.toString().toInt()
            Option.start(this, baseUrl, baseUrlImageAndVideo, token, userId, quizId)
        }
    }
}