package com.example.aerolineanj

import android.view.View


interface ClickListener {

    fun onClick(vista: View, position: Int)
    fun onLongClick(vista: View, position: Int)

    fun onItemClick(position: Int)
    fun onLongItemClick(position: Int)
}