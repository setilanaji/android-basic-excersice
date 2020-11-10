package com.example.androidmaterial

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidmaterial.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btNext.setOnClickListener {
                val intent = Intent(this@SecondActivity, ResultActivity::class.java)
                startActivityForResult(intent, REQUEST_RESULT)
            }
        }

//        val nextButton = findViewById<Button>(R.id.btNext)
//        nextButton.setOnClickListener {
//
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_RESULT && resultCode == RESULT_OK){
            data?.apply {
                val text = getStringExtra(ResultActivity.RESULT_ID)
                showDialog(this@SecondActivity, "Result", text.toString())
            }
        }
    }

    companion object{
        private const val REQUEST_RESULT = 1
    }

    private fun showDialog(context: Context, title: String, message: String){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.show()
    }
}