package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class Thank_You : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank__you)
        var ctn:Button = findViewById(R.id.fnsh)
        var window:Window = window
        window.statusBarColor = resources.getColor(R.color.green)
        ctn.setOnClickListener {
            startActivity(Intent(this@Thank_You,Home::class.java))
            finishAffinity()
        }
    }
}
