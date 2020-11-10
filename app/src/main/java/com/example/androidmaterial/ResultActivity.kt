package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.androidmaterial.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btBack.setOnClickListener {
                val data = Intent().putExtra(RESULT_ID, eTvResult.text.toString())
                setResult(RESULT_OK, data)
                finish()
            }
        }
    }

    companion object{
        const val RESULT_ID = "result"
    }
}