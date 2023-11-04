package com.panevrn.museumsapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "MuseumsDB"
const val DATABASE_VERSION = 1

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    //Команда, которой мы создаем таблицу
    private val CREATE_MUSEUMS_TABLE = """
        CREATE TABLE museums (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            description TEXT,
            phoneNumber TEXT,
            urlMuseum TEXT,
            address TEXT,
            imagePath INTEGER
        );
        """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_MUSEUMS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun addMuseum(museum: Museum) {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put("name", museum.name)
            put("description", museum.description)
            put("phoneNumber", museum.phoneNumber)
            put("urlMuseum", museum.urlMuseum)
            put("address", museum.address)
            put("imagePath", museum.imagePath)
        }

        db.insert("museums", null, values)
        db.close()
    }

    fun getAllMuseums(): List<Museum> {
        val museumsList = mutableListOf<Museum>()
        val db = this.readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("SELECT * FROM museums", null)
            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                    val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"))
                    val urlMuseum = cursor.getString(cursor.getColumnIndexOrThrow("urlMuseum"))
                    val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                    val imagePath = cursor.getInt(cursor.getColumnIndexOrThrow("imagePath"))
                    val myObject = Museum(id, name, description, phoneNumber, urlMuseum, address, imagePath)
                    museumsList.add(myObject)
                } while (cursor.moveToNext())
            }
            cursor.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db.close()
        }
        return museumsList
    }

    fun getMuseumById(id: Int): Museum? {
        val db = this.readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("SELECT * FROM museums WHERE id = ?", arrayOf(id.toString()))
            if (cursor.moveToFirst()) {
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                val phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"))
                val urlMuseum = cursor.getString(cursor.getColumnIndexOrThrow("urlMuseum"))
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                val imagePath = cursor.getInt(cursor.getColumnIndexOrThrow("imagePath"))
                return Museum(id, name, description, phoneNumber, urlMuseum, address, imagePath)
            }
            cursor.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db.close()
        }
        return null // Если объект не найден
    }

}