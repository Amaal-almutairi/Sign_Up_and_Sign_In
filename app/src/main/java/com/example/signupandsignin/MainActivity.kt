package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnsignIn:Button
    lateinit var btnsignUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsignIn=findViewById(R.id.btnsignInMain)
        btnsignIn.setOnClickListener {
            SignInPage()
        }

        btnsignUp=findViewById(R.id.btnsignupMain)
        btnsignUp.setOnClickListener {
            SignupPage()
        }


    }

    fun SignupPage() {
        intent = Intent(applicationContext, Sign_Up::class.java)
        startActivity(intent)
    }
    fun SignInPage(){
        intent = Intent(applicationContext, Sign_In::class.java)
        startActivity(intent)
    }
}