package com.panevrn.museumsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToSecond = findViewById<Button>(R.id.buttonLogin)
        buttonToSecond.setOnClickListener {
            val intent = Intent(this, MuseumsActivity::class.java)
            startActivity(intent)
        }
    }
}