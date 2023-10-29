package com.panevrn.museumsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MuseumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museums)

        val listMuseums: ArrayList<Museum> = arrayListOf()
        val mus1: Museum = Museum("Tretyakovka", "Good mus", "89850826446", "https:penis", "Street Barklaya", "res/drawabale")
        val mus2: Museum = Museum("Tretyakovka", "Good mus", "89850826446", "https:penis", "Street Barklaya", "res/drawabale")
        val mus3: Museum = Museum("Tretyakovka", "Good mus", "89850826446", "https:penis", "Street Barklaya", "res/drawabale")

        listMuseums.add(mus1)
        listMuseums.add(mus2)
        listMuseums.add(mus3)

    }
}