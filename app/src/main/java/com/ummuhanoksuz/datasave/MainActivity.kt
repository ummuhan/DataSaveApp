package com.ummuhanoksuz.datasave

import android.content.SharedPreferences
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
    lateinit var data:TextView
    lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.edit)
        data=findViewById(R.id.data)
        sharedPref=this.getSharedPreferences("com.ummuhanoksuz.datasave", MODE_PRIVATE)

        var name=sharedPref.getString("name","")
        if(!name.equals("")){
            data.text="Adınız: "+name.toString().toUpperCase()
        }
    }
    fun Save(view: View){
        var myName=textView.text.toString()
        data.text="Adınız: "+myName.toUpperCase()
        sharedPref.edit().putString("name",myName).apply()
    }
    fun Delete(view:View){
        var name=sharedPref.getString("name","")
        if(name!=""){
            sharedPref.edit().remove("name").apply()
            data.text="Kayıtlı İsminiz Bulunmuyor"
            textView.text.clear()
        }
    }
}