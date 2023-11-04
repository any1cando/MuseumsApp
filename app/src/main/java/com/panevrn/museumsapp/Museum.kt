package com.panevrn.museumsapp

import java.lang.invoke.TypeDescriptor

data class Museum(
    val id: Int,
    val name: String,
    val description: String,
    val phoneNumber: String,
    val urlMuseum: String,
    val address: String,
    val imagePath: Int
)
{ }