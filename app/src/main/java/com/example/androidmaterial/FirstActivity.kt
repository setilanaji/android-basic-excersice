package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        val text = findViewById<EditText>(R.id.eTvInput)
        val button = findViewById<Button>(R.id.btEnter)
        button.setOnClickListener {

           val intent =  Intent(this.applicationContext, DetailActivity::class.java )
            intent.putExtra("data", text.text.toString())
            startActivity(intent)
        }

    }
}