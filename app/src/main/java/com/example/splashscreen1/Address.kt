package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class Address : AppCompatActivity() {

    lateinit var city:EditText
    lateinit var locality:EditText
    lateinit var flat_no:EditText
    lateinit var pincode:EditText
    lateinit var name:EditText
    lateinit var mobile_no:EditText
    lateinit var email:EditText
    lateinit var paynow:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        city =findViewById(R.id.city)
        locality =findViewById(R.id.locality)
        flat_no =findViewById(R.id.flat_no)
        pincode =findViewById(R.id.pincode)
        name = findViewById(R.id.name)
        mobile_no =findViewById(R.id.city)
        email =findViewById(R.id.city)


        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Details")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)



         paynow = findViewById(R.id.payment)
        paynow.setOnClickListener {

            if (TextUtils.isEmpty(city.text.toString().trim())){
                city.setError("City is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(locality.text.toString().trim())){
                locality.setError("Locality is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(flat_no.text.toString().trim())){
                flat_no.setError("Flat No is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(pincode.text.toString().trim())){
                pincode.setError("Pincode is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(name.text.toString().trim())){
                name.setError("Name is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(mobile_no.text.toString().trim())){
                mobile_no.setError("Mobile No is required!")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(email.text.toString().trim())){
                email.setError("Email is required!")
                return@setOnClickListener
            }

            var i:Intent = Intent(this@Address,Payment::class.java).apply {
                putExtra("Name",name.text.toString())
            }
            startActivity(i)

        }


    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
