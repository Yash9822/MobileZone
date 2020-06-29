package com.example.splashscreen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class Help_Center : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help__center)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Help Center")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
