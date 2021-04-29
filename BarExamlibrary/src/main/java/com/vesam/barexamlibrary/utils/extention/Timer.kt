package com.vesam.barexamlibrary.utils.extention

import android.util.Log
import android.widget.ProgressBar
import java.util.concurrent.TimeUnit


fun initTick(millisUntilFinished: Long, progressBar: ProgressBar) {
    val second = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
    Log.d("TAG", "initTick: "+second)
    progressBar.progress = second.toInt()
}