package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val textEmail = findViewById<EditText>(R.id.eTvEmail)
        val textPassword = findViewById<EditText>(R.id.eTvPassword)

        val buttonLogin = findViewById<Button>(R.id.btLogin)
        buttonLogin.setOnClickListener {
                if (textEmail.text.toString().isEmailValid() && textPassword.text.toString().isPasswordValid()){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

        }

    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun String.isPasswordValid(): Boolean{


        return !TextUtils.isEmpty(this) && this.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"))
    }


}