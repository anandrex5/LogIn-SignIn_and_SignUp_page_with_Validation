package com.company0ne.firstproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class ActivityLogin : AppCompatActivity() {
    private lateinit var editTextUserName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button
    private lateinit var buttonSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Enable the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        editTextUserName = findViewById(R.id.editText_userName)
        editTextPassword = findViewById(R.id.editText_userPassword)
        buttonSignIn = findViewById(R.id.button_SignIn)
        buttonSignUp = findViewById(R.id.button_signUP)

        //set OnclickListener on SignUp Button
        buttonSignUp.setOnClickListener {
            val username = editTextUserName.text.toString()
            val password = editTextPassword.text.toString()

//            //Perform Validation
//            if(validateInput(username,password))
//            {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
//            }

        }
        buttonSignIn.setOnClickListener {
            val username = editTextUserName.text.toString()
            val password = editTextPassword.text.toString()

//            //Perform Validation
//            if (validateInput(username, password)) {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
////                finish()
//            }
//
//        }
//
//    }
//
//    private fun validateInput(username: String, password: String): Boolean {
//        if (username.isBlank() || password.isBlank()) {
//
//            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
//            return false
//        }
//        //other validation code
//
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle back button clicks
//        if (item.itemId == android.R.id.home) {
//            onBackPressed()
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//}

            // Perform Validation
            if (validateInput(username, password)) {
                // Retrieve the saved username and password from SharedPreferences
                val savedUsername = getSharedPreferencesData("username")
                val savedPassword = getSharedPreferencesData("password")

                // Check if the entered username and password match the saved values
                if (username == savedUsername && password == savedPassword) {
                    // Login successful, proceed to the next Activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        if (username.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            return false
        }
        // Perform additional validation logic if needed

        return true
    }

    private fun getSharedPreferencesData(key: String): String {
        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}