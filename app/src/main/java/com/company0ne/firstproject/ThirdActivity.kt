package com.company0ne.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ThirdActivity : AppCompatActivity() {

    private lateinit var maleRadioButton: RadioButton
    private lateinit var femaleRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        // Enable the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.buttonSendData)

        //Radiobutton
        maleRadioButton = findViewById(R.id.radioMale)
        femaleRadioButton = findViewById(R.id.radioFemale)

        button.setOnClickListener {
            sendDataToFourthActivity()
        }
    }

    private fun sendDataToFourthActivity() {
        //set  userName
        val editText = findViewById<EditText>(R.id.userName)
        val username = editText.text.toString()
        //set userEmail
        val editText1 = findViewById<EditText>(R.id.userEmail)
        val userEmail = editText1.text.toString()
        //set userAge
        val editText2 = findViewById<EditText>(R.id.userAge)
        val userAge = editText2.text.toString()
        //set userMobile
        val editText3 = findViewById<EditText>(R.id.userMobile)
        val userMobile = editText3.text.toString()


        // Validate the form
        if (username.isBlank() || userEmail.isBlank() || userAge.isBlank() || userMobile.isBlank()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT)
                .show()
            return
        }

        // Validate email format
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate phone number length
        if (userMobile.length != 10) {
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT)
                .show()
            return
        }

        // Validate age format
        val agePattern = Regex("^(0?[1-9]|[1-9][0-9])$")
        if (!userAge.matches(agePattern)) {
            Toast.makeText(this, "Please enter a valid age between 1 and 99", Toast.LENGTH_SHORT)
                .show()
            return
        }

        // Validate gender selection
        if (!maleRadioButton.isChecked && !femaleRadioButton.isChecked) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            return
        }

        //Pass the RadioButton data
        val intent = Intent(this, FourthActivity::class.java)
        if (maleRadioButton.isChecked) {
            intent.putExtra("gender", "Male")
        } else if (femaleRadioButton.isChecked) {
            intent.putExtra("gender", "Female")
        }

        //pass the Data
        intent.putExtra("userName", username)
        intent.putExtra("userEmail", userEmail)
        intent.putExtra("userAge", userAge)
        intent.putExtra("userMobile", userMobile)
//        intent.putExtra("gender", "Male")
//        intent.putExtra("gender", "Female")
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle back button clicks
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}





