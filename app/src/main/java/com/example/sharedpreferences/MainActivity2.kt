package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var sharedPreference:SharedPreferences
    private lateinit var tv1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
        val loggedin = sharedPreference.getBoolean("isLoggedIn", false)
        if(loggedin){
            val dispuname = sharedPreference.getString("username","")
            tv1 = findViewById(R.id.tv1)
            tv1.text = "Hello, $dispuname"
        }
    }
}