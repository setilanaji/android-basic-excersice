package com.example.androidmaterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonOne = findViewById<Button>(R.id.btOne)
        val buttonTwo = findViewById<Button>(R.id.btTwo)
        val buttonThree = findViewById<Button>(R.id.btThree)

    }
}