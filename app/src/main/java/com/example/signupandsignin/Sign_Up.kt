package com.example.signupandsignin

import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Sign_Up : AppCompatActivity() {
    lateinit var ednamesignup:EditText
    lateinit var edmobile:EditText
    lateinit var edlocationsignup:EditText
    lateinit var edpw:EditText
    lateinit var btnsubmitsignup:Button
    var name=""
    var mobile = ""
    var location= ""
    var pw =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var DB = DBHlp(this)
        ednamesignup=findViewById(R.id.ednamesignup)
        edmobile = findViewById(R.id.edmobile)
        edlocationsignup=findViewById(R.id.edlocationsignup)
        edpw = findViewById(R.id.edpwsignup)
        btnsubmitsignup = findViewById(R.id.btnsubmit)
        btnsubmitsignup.setOnClickListener {
            try {
                name = ednamesignup.text.toString()
                   mobile= edmobile.text.toString()
                 location = edlocationsignup.text.toString()
                 pw =edpw.text.toString()
              var infosave=  DB.Save(name,mobile,location,pw)

                Toast.makeText(this, "Data Saved Successfully" + infosave, Toast.LENGTH_SHORT).show()
                var intent = Intent(this,Details::class.java)
                intent.putExtra("User", name)

                startActivity(intent)

            }catch (e:Exception){
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            }

        }
    }


}