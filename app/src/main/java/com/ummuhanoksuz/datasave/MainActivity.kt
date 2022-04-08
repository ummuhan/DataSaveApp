package com.ummuhanoksuz.datasave

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var textView: EditText
    lateinit var saveButton:Button
    lateinit var deleteButton: Button
    lateinit var data:TextView
    lateinit var sharedPref:SharedPreferences
    lateinit var setName:EditText
    lateinit var setSurname:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"Hoşgeldiniz!",Toast.LENGTH_LONG).show()
        textView=findViewById(R.id.edit)
        data=findViewById(R.id.data)
        sharedPref=this.getSharedPreferences("com.ummuhanoksuz.datasave", MODE_PRIVATE)
        setName=findViewById(R.id.setName)
        setSurname=findViewById(R.id.setSurname)

        var name=sharedPref.getString("name","")
        if(!name.equals("")){
            data.text="Adınız: "+name.toString().toUpperCase()
        }
    }
    fun Save(view: View){
        var alert=AlertDialog.Builder(this)
        alert.setTitle("Uyarı")
        alert.setMessage("Kayıt etmek istediğinizden emin misiniz?")
        alert.setPositiveButton("Evet"){
            dialog, which->
            var myName=textView.text.toString()
            data.text="Adınız: "+myName.toUpperCase()
            sharedPref.edit().putString("name",myName).apply()
            Toast.makeText(applicationContext,"Başarılı bir şekilde kayıt edildi",Toast.LENGTH_SHORT).show()
        }
        alert.setNegativeButton("Hayır"){
            dialog, which->
            Toast.makeText(applicationContext,"Kayıt işlemi başarısız",Toast.LENGTH_SHORT).show()
        }
        alert.show()
    }
    fun Delete(view:View){
        var name=sharedPref.getString("name","")
        if(name!=""){
            sharedPref.edit().remove("name").apply()
            data.text="Kayıtlı İsminiz Bulunmuyor"
            textView.text.clear()
        }
    }
    fun nextPage(view:View){
        var intent=Intent(applicationContext,NextActivity::class.java)
        intent.putExtra("name",setName.text.toString().toUpperCase())
        intent.putExtra("surname",setSurname.text.toString().toUpperCase())
        startActivity(intent)
    }
}