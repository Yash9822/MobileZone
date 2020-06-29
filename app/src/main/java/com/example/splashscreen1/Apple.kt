package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Apple : AppCompatActivity() {

    val productview = arrayOf(products("Apple iphone 11, 64GB","Black","₹64,885","₹68,300",R.drawable.ic_line_thick,"5% Off" ,"Delivery in 2-3 days", R.drawable.iphone),
            products("Apple iPhone 11 Pro, 64GB","Midnight Green","₹98,072","₹1,06,600",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 2-3 days", R.drawable.elevenpro4),
            products("Apple iPhone X, 64GB","Silver","₹79,899","₹84,999",R.drawable.ic_line_thick,"6% Off" ,"Delivery in 2-3 days", R.drawable.iphonex5),
            products("Apple iPhone 8 Plus, 64GB","RED","₹51,930","₹52,990",R.drawable.ic_line_thick,"2% Off" ,"Delivery in 2-3 days", R.drawable.eight1),
            products("Apple iPhone 7, 32GB","Black","₹28,499","₹29,900",R.drawable.ic_line_thick,"4% Off" ,"Delivery in 2-3 days", R.drawable.seven1),
            products("Apple iPhone 6s, 32GB","Rose Gold","₹28,585","₹29,777",R.drawable.ic_line_thick,"4% Off" ,"Delivery in 2-3 days", R.drawable.sixs1),
            products("Apple iPhone SE, 64GB","Black","₹41,650","₹42,500",R.drawable.ic_line_thick,"2% Off" ,"Delivery in 2-3 days", R.drawable.se1),
            products("Apple iPhone XS, 64GB","Gold","₹59,999","₹89,900",R.drawable.ic_line_thick,"33% Off" ,"Delivery in 2-3 days", R.drawable.xs1))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apple)


        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Apple")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Apple)
            adapter = productAdapter{

                var i:Intent = Intent(this@Apple,Discription::class.java).apply {
                    putExtra("title",it.title)
                    putExtra("color",it.color)
                    putExtra("new_Price",it.newPrice)
                    putExtra("price",it.price)
                    putExtra("discount",it.Discount)
                    putExtra("image",it.productId)

                }

                startActivity(i)

            }.apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)

        }

        (product_list.adapter as productAdapter).productData = productview

        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }

