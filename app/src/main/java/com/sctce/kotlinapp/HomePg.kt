package com.sctce.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button


class HomePg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pg)
        //splash screen
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this@HomePg, MainActivity::class.java)
            startActivity(intent)
            finish()
        },2300)

    }
}