package com.example.androidmaterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val textInput = findViewById<EditText>(R.id.eTvResult)
        val buttonBack = findViewById<Button>(R.id.btBack)
        buttonBack.setOnClickListener {
            
        }
    }
}