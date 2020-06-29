package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Oppo : AppCompatActivity() {

    val productview = arrayOf(products("OPPO Find X , 256 GB","Glacier Blue","₹60,990","₹60,990",R.drawable.ic_line_thick,"0% Off" ,"Delivery in 2-3 days", R.drawable.findx),
            products("OPPO A3s, 32 GB","Red","₹12,990","₹12,990",R.drawable.ic_line_thick,"0% Off" ,"Delivery in 2-3 days", R.drawable.a3s1),
            products("OPPO A9 2020, 128 GB","Marine Green,","₹19,990","₹21,992",R.drawable.ic_line_thick,"9% Off" ,"Delivery in 2-3 days", R.drawable.oppoa91))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oppo)
        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Oppo")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Oppo)
            adapter = productAdapter{

                var i:Intent = Intent(this@Oppo,Discription::class.java).apply {
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
