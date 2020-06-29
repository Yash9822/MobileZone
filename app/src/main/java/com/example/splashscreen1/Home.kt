package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {

    lateinit var brandList:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val brandData = arrayOf(Brands("Apple",R.drawable.apple),Brands("Samsung",R.drawable.samsung),Brands("Oppo",R.drawable.oppo)
                ,Brands("Vivo",R.drawable.vivo),Brands("Oneplus",R.drawable.oneplus),Brands("Realme",R.drawable.realme),Brands("Nokia",R.drawable.nokia)
                ,Brands("Honor",R.drawable.honor),Brands("Google",R.drawable.google),Brands("Mi",R.drawable.mi))

        var logOut:ImageView = findViewById(R.id.logOut)

        val trending:ImageView = findViewById(R.id.trending)
        brandList = findViewById(R.id.brandList)
        var contactus:Button = findViewById(R.id.help_center)

        contactus.setOnClickListener {
            startActivity(Intent(this@Home,Help_Center::class.java))
        }


        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@Home,Login::class.java))
            finish()
        }
        trending.setOnClickListener(){
            startActivity(Intent(this@Home,Trending::class.java))
        }

        val brandAdapter = BrandAdapter(brandData)
        brandList.adapter = brandAdapter
        brandList.setOnItemClickListener { parent, view, position, id ->
            when (position){

                0->{

                    startActivity(Intent(this@Home,Apple::class.java))

                }
                1->{
                    startActivity(Intent(this@Home,Samsung::class.java))

                }
                2->{
                    startActivity(Intent(this@Home,Oppo::class.java))

                }
                3->{
                    startActivity(Intent(this@Home,Vivo::class.java))

                }
                4->{
                    startActivity(Intent(this@Home,Oneplus::class.java))

                }
                5->{
                    startActivity(Intent(this@Home,Realme::class.java))

                }
                6->{
                    startActivity(Intent(this@Home,Nokia::class.java))

                }
                7->{
                    startActivity(Intent(this@Home,Honor::class.java))

                }
                8->{
                    startActivity(Intent(this@Home,Google::class.java))

                }
                9->{
                    startActivity(Intent(this@Home,Mi::class.java))

                }
                else->{
                    return@setOnItemClickListener
                }
            }

        }

    }
}
