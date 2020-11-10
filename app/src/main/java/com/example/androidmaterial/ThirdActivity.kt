package com.example.androidmaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class ThirdActivity : AppCompatActivity() {

    private lateinit var textEmailField: TextInputLayout
    private lateinit var textPasswordField: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // hide action bar
        this.supportActionBar?.hide()

        textEmailField = findViewById<TextInputLayout>(R.id.tfEmail)
        textPasswordField = findViewById<TextInputLayout>(R.id.tfPassword)

        val textEmail = findViewById<EditText>(R.id.etfEmail)
        val textPassword = findViewById<EditText>(R.id.etfPassword)

        val buttonLogin = findViewById<Button>(R.id.btLogin)


        buttonLogin.setOnClickListener {

                // final check
                if (textEmail.text.toString().isEmailValid() && textPassword.text.toString().isPasswordValid()){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else{
                    textEmailField.isErrorEnabled = true
                    textPasswordField.isErrorEnabled = true
                }
        }

        textEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                setEmailError(s)
            }
        })

        textPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                setPasswordError(s)
            }
        })

        textEmail.onFocusChangeListener = View.OnFocusChangeListener{
                _, hasFocus -> if (!hasFocus) setEmailError(textEmail.text)
        }

        textPassword.onFocusChangeListener = View.OnFocusChangeListener{
                _, hasFocus -> if (!hasFocus) setPasswordError(textPassword.text)
        }

    }

    // set Email error
    fun setEmailError(s: Editable?){
        textEmailField.error = when{
            TextUtils.isEmpty(s.toString()) -> "email must not be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches() -> "email format is not correct"
            else -> null
        }
    }

    // set Password Error
    fun setPasswordError(s: Editable?){
        textPasswordField.error = when{
            TextUtils.isEmpty(s.toString()) -> "password must not be empty"
            !s.toString().matches(Regex("^.{8,20}\$")) -> "password must in 8-20 characters"
            !s.toString().matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$")) -> "password must be alphanumeric"
            else -> null
        }
    }


    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun String.isPasswordValid(): Boolean{
        return !TextUtils.isEmpty(this) && this.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"))
    }




}