package com.example.androidmaterial

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.androidmaterial.databinding.ActivityThirdBinding
import com.google.android.material.textfield.TextInputLayout

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hide action bar
        this.supportActionBar?.hide()

        binding.run {
            btLogin.setOnClickListener {
                if (etfEmail.text.toString().isEmailValid() && etfPassword.text.toString().isPasswordValid()){
                    val intent = Intent(this@ThirdActivity, HomeActivity::class.java)
                    startActivity(intent)
                } else{
                    tfEmail.isErrorEnabled = true
                    tfPassword.isErrorEnabled = true
                }
            }

            etfEmail.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) = setEmailError(s)
            })

            etfPassword.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) = setPasswordError(s)
            })

            etfEmail.onFocusChangeListener = View.OnFocusChangeListener{
                    _, hasFocus -> if (!hasFocus) setEmailError(etfEmail.text)
            }

            etfPassword.onFocusChangeListener = View.OnFocusChangeListener{
                    _, hasFocus -> if (!hasFocus) setPasswordError(etfPassword.text)
            }
        }

    }

    // set Email error
    private fun setEmailError(s: Editable?){
        binding.tfEmail.error = when{
            TextUtils.isEmpty(s.toString()) -> "email must not be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches() -> "email format is not correct"
            else -> null
        }
    }

    // set Password Error
    private fun setPasswordError(s: Editable?){
        binding.tfPassword.error = when{
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