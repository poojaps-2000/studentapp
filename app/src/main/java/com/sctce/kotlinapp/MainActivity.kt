package com.sctce.kotlinapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pg)

        val bOne: Button = findViewById(R.id.busa)
        val bTwo: Button = findViewById(R.id.busb)
        val bThree: Button = findViewById(R.id.busc)
        val abtUs: Button = findViewById(R.id.abtus)
         bOne.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS A"
            intent.putExtra("id",id)
            startActivity(intent)
        }

        bTwo.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS B"
            intent.putExtra("id",id)
            startActivity(intent)
        }

        bThree.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            val id = "BUS C"
            intent.putExtra("id",id)
            startActivity(intent)
        }
        abtUs.setOnClickListener{
            val intent = Intent(this@MainActivity, AboutPg::class.java)
            startActivity(intent)
        }
    }

}