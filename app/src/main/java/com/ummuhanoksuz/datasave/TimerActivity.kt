package com.ummuhanoksuz.datasave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class TimerActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        textView=findViewById(R.id.textView)
        object :CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                textView.text="Sayac: ${p0/1000}"
            }

            override fun onFinish() {
                textView.text="Görev Tamamlandı!!"
            }

        }.start()
    }
}