package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var display:TextView
    lateinit var display2:TextView
    lateinit var btnsignout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var DB = DBHlp(this)
        display=findViewById(R.id.textv)
        display2 = findViewById(R.id.textv2)
        btnsignout = findViewById(R.id.btnsignout)
        var name =intent.getStringExtra("User")
        var info = name?.let { it1 -> DB.retriveinfo(it1) }
        display.text ="Welcome  "+name
        display2.text="Your Details Are, \n \n "+info

        btnsignout.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}