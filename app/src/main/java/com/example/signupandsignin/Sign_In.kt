package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Sign_In : AppCompatActivity() {
    lateinit var edusername:EditText
    lateinit var edpassword:EditText
    lateinit var btnsignIn:Button
    var user=""
    var pass = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        var DB = DBHlp(this)
        edusername=findViewById(R.id.edusername)
        edpassword=findViewById(R.id.edpassword)
        btnsignIn=findViewById(R.id.btnsignIn2)

        try {

            user=edusername.text.toString()
            pass = edpassword.text.toString()
            DB.retriveinfo(user)

        }catch (e:Exception){
            Toast.makeText(this, "Enter user name and password", Toast.LENGTH_SHORT).show()
        }


        btnsignIn.setOnClickListener {
          var Cpass=DB.retrivepass(user)
           if (pass==Cpass){
               MoveSignin()
           }
            else{
               Toast.makeText(this, "Password You Entered Is Not Matching", Toast.LENGTH_SHORT).show()
           }

        }


    }
    fun MoveSignin(){

        var name =edusername.text.toString()
        var intent = Intent(this,Details::class.java)
        intent.putExtra("User", name)
        startActivity(intent)
   }
}