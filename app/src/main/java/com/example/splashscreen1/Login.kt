package com.example.splashscreen1

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ClickableSpan
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var Register: TextView
    lateinit var Email: TextView
    lateinit var Password : TextView
    lateinit var forgetPassword : TextView
    lateinit var progressBar : ProgressBar
    lateinit var signIn : Button
    lateinit var fAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        Register = findViewById(R.id.createAccount)
        Email = findViewById(R.id.Email)
        Password = findViewById(R.id.Password)
        forgetPassword =findViewById(R.id.forgetPassword)
        progressBar = findViewById(R.id.progressBar)
        signIn = findViewById(R.id.signUp)
        fAuth = FirebaseAuth.getInstance()


        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Login")

        if (fAuth.currentUser != null){
            startActivity(Intent(this@Login,Home::class.java))
            finish()
        }

        Register.setOnClickListener {
            val i: Intent = Intent(this@Login, com.example.splashscreen1.Register::class.java)
            startActivity(i)
            finish()
        }
        signIn.setOnClickListener {
            var email:String = Email.text.toString().trim()
            var passcode:String = Password.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                Email.setError("Email is required!")
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

            progressBar.setVisibility(View.VISIBLE)

            //authenticate the user

            fAuth.signInWithEmailAndPassword(email,passcode).addOnCompleteListener {
                if(it.isSuccessful()){
                    Toast.makeText(this@Login,"Login Sucessfully",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@Login,Home::class.java))
                    finish()
                }else{
                    Toast.makeText(this@Login,"Error !"+it.exception,Toast.LENGTH_LONG).show()
                    progressBar.setVisibility(View.GONE)
                }
            }

        }

    }

}
