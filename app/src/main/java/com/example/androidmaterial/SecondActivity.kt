package com.example.androidmaterial

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val nextButton = findViewById<Button>(R.id.btNext)
        nextButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_RESULT)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_RESULT && resultCode == RESULT_OK){
            data?.apply {
                val text = getStringExtra(ResultActivity.RESULT_ID)
                val builder = AlertDialog.Builder(this@SecondActivity)
                builder.setTitle("Result")
                builder.setMessage(text)
                builder.show()

            }
        }
    }

    companion object{
        private const val REQUEST_RESULT = 1
    }
}