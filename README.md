# LogIn-SignIn_and_SignUp_page_with_Validation
When user open the app the SplashScreen will appear and LogIn/SingIn page will open up if user have an account the he/she will direct login if not then he will create an account by clicking the SignUp button

**/*If User has credentials saved in shared preference when the user opens the app firstly,
splash screen will appear then the main activity will open because the user has credentials which is saved in SharedPreference ***/



//Make Changes in **SplashScreen** Activity - 

package com.company0ne.firstproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

//    private val SPLASH_TIME: Long = 3000
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash_screen)
//
//    Handler().postDelayed({
//        startActivity(Intent(this,MainActivity::class.java))
//        finish()
//    }, SPLASH_TIME)
//    }
//}


    // Duration of splash screen display (in milliseconds)
    private val SPLASH_DURATION = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        // Set the layout for the splash activity
//        setContentView(R.layout.activity_splash_screen)
//
//        // Delay the transition to the next activity
//        Handler().postDelayed({
//            val intent = Intent(this, ActivityLogin::class.java)
//            startActivity(intent)
//            finish()
//        }, SPLASH_DURATION)
//    }
//}

        // Check if the user has credentials saved in SharedPreferences
        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)

        // Delay the transition to the next activity based on credentials existence
        Handler().postDelayed({
            if (username != null && password != null) {
                // User has credentials, open MainActivity directly
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // User doesn't have credentials, open ActivityLogin
                val intent = Intent(this, ActivityLogin::class.java)
                startActivity(intent)
            }
            finish()
        }, SPLASH_DURATION)
    }
}
