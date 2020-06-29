package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Samsung : AppCompatActivity() {

    val productview = arrayOf(products("Samsung Galaxy S20 Ultra, 128 GB","Cosmic Gray","₹97,999","₹1,03,000",R.drawable.ic_line_thick,"4% Off" ,"Delivery in 2-3 days", R.drawable.s20ultra),
            products("Samsung Galaxy A50, 64 GB","Blue","₹15,499","₹121,000",R.drawable.ic_line_thick,"26% Off" ,"Delivery in 2-3 days", R.drawable.a501),
            products("Samsung Galaxy A9, 128 GB","Caviar Black","₹37,999","₹39,000",R.drawable.ic_line_thick,"2% Off" ,"Delivery in 2-3 days", R.drawable.a91),
            products("Samsung Galaxy A51, 128 GB","Prism Crush Black","₹25,250","₹25,999",R.drawable.ic_line_thick,"2% Off" ,"Delivery in 2-3 days", R.drawable.a511),
            products("Samsung Galaxy A80, 128 GB","Phantom Black","₹21,999","₹52,000",R.drawable.ic_line_thick,"57% Off" ,"Delivery in 2-3 days", R.drawable.a801),
            products("Samsung Galaxy M21, 64 GB","Raven Black","₹12,739","₹12,999",R.drawable.ic_line_thick,"2% Off" ,"Delivery in 2-3 days", R.drawable.galaxym211),
            products("Samsung Galaxy M30s , 64 GB","Black","₹15,083","₹15,550",R.drawable.ic_line_thick,"6% Off" ,"Delivery in 2-3 days", R.drawable.galaxym30s1),
            products("Samsung Galaxy A31, 128GB","Prism Crush Black ","₹21,999","₹23,999",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 3-4 days", R.drawable.samsunggalaxya31),
            products("Samsung Galaxy A80, 128GB","Ghost White","₹38,999","₹52,000",R.drawable.ic_line_thick,"25% Off" ,"Delivery in 3-4 days", R.drawable.galaxya80),
            products("Samsung Galaxy A50, 64 GB","Blue","₹15,499","₹21,000",R.drawable.ic_line_thick,"26% off" ,"Delivery in 3-4 days", R.drawable.samsunggalaxya50))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samsung)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Samsung")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Samsung)
            adapter = productAdapter{

                var i:Intent = Intent(this@Samsung,Discription::class.java).apply {
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
