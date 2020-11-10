package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.androidmaterial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // disable night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.run {
            btOne.setOnClickListener(this@MainActivity)
            btTwo.setOnClickListener(this@MainActivity)
            btThree.setOnClickListener(this@MainActivity)
        }
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