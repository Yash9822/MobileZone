package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var Login: TextView
    lateinit var Email : TextView
    lateinit var fullName: TextView
    lateinit var phoneNumber: TextView
    lateinit var Password: TextView
    lateinit var confirmPassword: TextView
    lateinit var signUp: Button
    lateinit var fAuth: FirebaseAuth
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        Login = findViewById(R.id.createAccount)
        fullName = findViewById(R.id.fullName)
        phoneNumber = findViewById(R.id.phoneNumber)
        Email = findViewById(R.id.Email)
        fAuth =FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressBar)
        Password = findViewById(R.id.Password)
        confirmPassword = findViewById(R.id.confirmPassword)
        signUp = findViewById(R.id.signUp)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Register")



        Login.setOnClickListener {
            val i: Intent = Intent(this@Register, com.example.splashscreen1.Login::class.java)
            startActivity(i)
            finish()
        }
        signUp.setOnClickListener {
            var email:String = Email.text.toString().trim()
            var passcode:String = Password.text.toString().trim()
            var confirmpasscode = confirmPassword.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                Email.setError("Email is required!")
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(fullName.text.toString().trim())){
                fullName.setError("Full Name is required!")
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(phoneNumber.text.toString().trim())){
                phoneNumber.setError("Phone Number is required!")
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(passcode)){
                Password.setError("Password is required!")
                return@setOnClickListener
            }
            if (passcode.length < 6){
                Password.setError("Password must be greater than or equal to 6")
                return@setOnClickListener
            }
            if (!passcode.equals(confirmpasscode)){
                Password.setError("your entered both password different")
                confirmPassword.setError("You entered both password different")
                return@setOnClickListener
            }
            progressBar.setVisibility(View.VISIBLE)

            fAuth.createUserWithEmailAndPassword(email,passcode).addOnCompleteListener {
                if (it.isSuccessful()){
                    Toast.makeText(this@Register,"User Registered",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@Register,Home::class.java))
                    finish()
                    progressBar.setVisibility(View.GONE)
                }else{
                    Toast.makeText(this@Register,"Error !"+it.exception,Toast.LENGTH_LONG).show()
                    progressBar.setVisibility(View.GONE)
                }
            }
        }
    }
}
