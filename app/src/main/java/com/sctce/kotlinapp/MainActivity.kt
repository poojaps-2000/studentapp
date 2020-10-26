package com.sctce.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bone: Button = findViewById(R.id.busa)
        bone.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS A"
            intent.putExtra("id",id)
            startActivity(intent)
        }
        val btwo: Button = findViewById(R.id.busb)
        btwo.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS B"
            intent.putExtra("id",id)
            startActivity(intent)
        }
        val bthree: Button = findViewById(R.id.busc)
        bthree.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS C"
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }
}