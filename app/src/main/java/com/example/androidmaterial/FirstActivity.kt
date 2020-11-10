package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.androidmaterial.databinding.ActivityFirstBinding


class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btEnter.setOnClickListener {
                val intent =  Intent(this@FirstActivity, DetailActivity::class.java )
                intent.putExtra("data", eTvInput.text.toString())
                startActivity(intent)
            }
        }
    }
}