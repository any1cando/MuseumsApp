package com.panevrn.museumsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.museumsapp.databinding.ActivityMainBinding

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
//    private fun init() {
//        val recycleView = findViewById<RecyclerView>(R.id.rcView)
//        recycleView.layoutManager = LinearLayoutManager(this@MainActivity)
//        recycleView.adapter = adapter
////        binding.apply {
////            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
////            rcView.adapter = adapter
////        }
//    }
}