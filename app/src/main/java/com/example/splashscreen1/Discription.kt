package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class Discription : AppCompatActivity() {

    lateinit var product_name:TextView
    lateinit var product_image:ImageView
    lateinit var new_price:TextView
    lateinit var price:TextView
    lateinit var discount:TextView
    lateinit var pricelist:TextView
    lateinit var amountpayable:TextView
    lateinit var final_price:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discription)
        product_name = findViewById(R.id.product_name)
        product_image = findViewById(R.id.product_image)
        new_price = findViewById(R.id.new_price)
        price = findViewById(R.id.price)
        discount = findViewById(R.id.discount)
        pricelist = findViewById(R.id.pricelist)
        amountpayable = findViewById(R.id.AmountPayable)
        final_price = findViewById(R.id.final_price)

        val proceed:Button = findViewById(R.id.proceed)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Order Summary")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

       var title:String? = intent.getStringExtra("title")
        var color:String? = intent.getStringExtra("color")
        var intentnew_Price:String? = intent.getStringExtra("new_Price")
        var intentprice = intent.getStringExtra("price")
        var intentdiscount:String? = intent.getStringExtra("discount")
        var image = intent.getIntExtra("image",0)

        product_name.setText(title)
        new_price.setText(intentnew_Price)
        price.setText(intentnew_Price)
        discount.setText(intentdiscount)
        pricelist.setText(intentnew_Price)
        amountpayable.setText(intentnew_Price)
        final_price.setText(intentnew_Price)
        product_image.setImageResource(image)

        proceed.setOnClickListener {
            startActivity(Intent(this@Discription,Address::class.java))
        }


    }

     override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
