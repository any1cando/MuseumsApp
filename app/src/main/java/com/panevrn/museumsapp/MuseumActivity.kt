package com.panevrn.museumsapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MuseumActivity : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        val intent = intent

        val museumID = intent.getIntExtra("id", -1)

        dbHelper = DBHelper(this)

        val writtenMuseum: Museum? = dbHelper.getMuseumById(museumID)

        val image = findViewById<ImageView>(R.id.imageViewMuseum)
        val name = findViewById<TextView>(R.id.textViewMuseumName)
        val description = findViewById<TextView>(R.id.textViewMuseumDescription)
        val address = findViewById<TextView>(R.id.textViewMuseumAddress)
        val phoneNumber = findViewById<TextView>(R.id.textViewMuseumPhoneNumber)
        val urlAddress = findViewById<TextView>(R.id.textViewMuseumURL)

        image.setImageResource(writtenMuseum!!.imagePath)
        name.text = writtenMuseum.name
        description.text = writtenMuseum.description
        address.text = writtenMuseum.address
        phoneNumber.text = writtenMuseum.phoneNumber
        urlAddress.text = writtenMuseum.urlMuseum
    }
}