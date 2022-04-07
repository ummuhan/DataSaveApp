package com.ummuhanoksuz.datasave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NextActivity : AppCompatActivity() {
    lateinit var nameText:TextView
    lateinit var surnameText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        nameText=findViewById(R.id.getName)
        surnameText=findViewById(R.id.getSurname)
        var intent=intent
        nameText.text="İSİM: "+intent.getStringExtra("name")
        surnameText.text="SOYİSİM: "+intent.getStringExtra("surname")
    }
}