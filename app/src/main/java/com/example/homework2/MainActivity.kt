package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.LogPrinter
import android.util.Patterns
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var isValideEmail = true
    var isPasswordValide = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hometask2)


        val button = findViewById<Button>(R.id.button)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)


        fun setValidation() {
            if (email.text.toString().isEmpty()) {
                email.setError(resources.getString(R.string.email_error))
                isValideEmail = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                email.setError(resources.getString(R.string.error_invalid_email))
                isValideEmail = false
            } else {
                isValideEmail = true
            }
            if (password.text.toString().isEmpty()) {
                password.setError(getResources().getString(R.string.password_error))
                isPasswordValide = false
            } else if (password.text.length < 8) {
                password.setError(getResources().getString(R.string.error_invalid_password))
                isPasswordValide = false
            } else {
                isPasswordValide = true
            }

            if (isPasswordValide && isValideEmail) {
                Toast.makeText(applicationContext, "Successfully", Toast.LENGTH_SHORT).show()
            }

        }
        button.setOnClickListener {
            setValidation();
            Toast.makeText(applicationContext, "${email.text}", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, "${password.text}", Toast.LENGTH_SHORT).show()
        }


        val spinner = findViewById<Spinner>(R.id.spinner)
        val elements = arrayOf("Male","Female")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,elements)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"Selected element is ${elements[position]}",Toast.LENGTH_SHORT)
                    .show()
            }

        }


    }
}