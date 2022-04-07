package com.ummuhanoksuz.datasave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: EditText
    lateinit var saveButton:Button
    lateinit var deleteButton: Button
    lateinit var date:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.edit)
    }
    fun Save(view: View){

    }
}