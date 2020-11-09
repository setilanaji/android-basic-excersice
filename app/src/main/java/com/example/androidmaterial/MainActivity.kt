package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // disable night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val buttonOne = findViewById<Button>(R.id.btOne)
        val buttonTwo = findViewById<Button>(R.id.btTwo)
        val buttonThree = findViewById<Button>(R.id.btThree)

        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)

    }

    // overriding onClick method
    override fun onClick(v: View?) {
        // id selection
        when(v!!.id){
            R.id.btOne -> startActivity(Intent(this, FirstActivity::class.java))
            R.id.btTwo -> startActivity(Intent(this, SecondActivity::class.java))
            R.id.btThree ->  startActivity(Intent(this, ThirdActivity::class.java))

        }
    }
}