package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlp (context: Context):SQLiteOpenHelper(context,"Details.db",null,1){
    var sqlit:SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
       if (db != null){
           db.execSQL("Create table users(User Text, Mobile Text, Location Text, PW Text)")
       }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun Save(name:String,mobile:String,location:String,pw:String): Long{
        val cv = ContentValues()
        cv.put("User",name)
        cv.put("Mobile",mobile)
        cv.put("Location",location)
        cv.put("PW",pw)

        var SD:Long =sqlit.insert("users", null,cv)
        return SD;

    }

    @SuppressLint("Range")
    fun retriveinfo(name:String):String{
        var c:Cursor = sqlit.query("users", null ,"User=?", arrayOf(name), null,null,null)

        c.moveToFirst()
        //will return  name and location
        var info = c.getString(c.getColumnIndex("Mobile"))+"\n"+c.getString(c.getColumnIndex("Location"))

        return info
    }


    @SuppressLint("Range")
    fun retrivepass(name:String):String{
        var c:Cursor = sqlit.query("users", null ,"User=?", arrayOf(name), null,null,null)

        c.moveToFirst()
        //will return  name and location
        var CurrentPass = c.getString(c.getColumnIndex("PW"))

        return CurrentPass
    }


}