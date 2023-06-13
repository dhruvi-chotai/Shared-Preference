package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreference.getBoolean("isLoggedIn", false)
        if(isLoggedIn){
            startMainActivity2()
            return
        }
        btn = findViewById(R.id.submit_btn)
        btn.setOnClickListener{
            val username = findViewById<EditText>(R.id.name_et).text.toString()
            val pwd = findViewById<EditText>(R.id.pwd_et).text.toString()

            //we will write validation code here
            if(isloggedin(username, pwd)){
                sharedPreference.edit().putBoolean("isLoggedIn", true).apply()
                sharedPreference.edit().putString("username", username).apply()
                startMainActivity2()
            }
        }

    }
    private fun isloggedin(username:String, pwd:String):Boolean {
        return username.isNotEmpty() && pwd.isNotEmpty()
    }

    private fun startMainActivity2(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}