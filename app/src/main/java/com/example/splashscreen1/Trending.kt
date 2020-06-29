package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Trending : AppCompatActivity() {

    val productview = arrayOf(products("Vivo NEX, 128GB","Black","₹23,990","₹39,900",R.drawable.ic_line_thick,"40% Off" ,"Delivery in 3-4 days", R.drawable.vivonex),
            products("Redmi Note 7 Pro, 64GB","Space Black","₹12,999","₹16,999",R.drawable.ic_line_thick,"23% off" ,"Delivery in 3-4 days", R.drawable.miredminote7pro),
            products("OPPO A9 2020, 128GB","Marine Green","₹13,990","₹18,990",R.drawable.ic_line_thick,"26% off" ,"Delivery in 3-4 days", R.drawable.oppoa9),
            products("Apple Iphone 7 Plus,32GB","Black","₹34,999","₹37,900",R.drawable.ic_line_thick,"7% off" ,"Delivery in 3-4 days", R.drawable.iphone7plus),
            products("Vivo Z1x, 128GB","Fusion Blue","₹17,990","₹24,990",R.drawable.ic_line_thick,"28% Off" ,"Delivery in 3-4 days", R.drawable.vivoz1x),
            products("OPPO F15, 128 GB","Unicorn White","₹18,990","₹22,990",R.drawable.ic_line_thick,"17% off" ,"Delivery in 3-4 days", R.drawable.oppof15),
            products("OnePlus 7T Pro, 256GB ","Haze Blue","₹48,300","₹50,500",R.drawable.ic_line_thick,"4% off" ,"Delivery in 3-4 days", R.drawable.oneplus7tpro),
            products("Samsung Galaxy A31, 128GB","Prism Crush Black ","₹21,999","₹23,999",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 3-4 days", R.drawable.samsunggalaxya31),
            products("Samsung Galaxy A80, 128GB","Ghost White","₹38,999","₹52,000",R.drawable.ic_line_thick,"25% Off" ,"Delivery in 3-4 days", R.drawable.galaxya80),
            products("Realme Narzo 10A, 32GB","So Blue","₹34,999","₹37,900",R.drawable.ic_line_thick,"7% off" ,"Delivery in 3-4 days", R.drawable.realmenarzo),
            products("Redmi K20 Pro, 128GB","Flame Red","₹24,999","₹28,999",R.drawable.ic_line_thick,"13% off" ,"Delivery in 3-4 days", R.drawable.redmik20pro),
            products("Apple Iphone 11, 64GB","Black","₹64,885","₹68,300",R.drawable.ic_line_thick,"5% Off" ,"Delivery in 3-4 days", R.drawable.iphone),
            products("Samsung Galaxy A50, 64 GB","Blue","₹15,499","₹21,000",R.drawable.ic_line_thick,"26% off" ,"Delivery in 3-4 days", R.drawable.samsunggalaxya50),
            products("Realme X3 SuperZoom, 256 GB","Glacier Blue","₹32,999","₹34,999",R.drawable.ic_line_thick,"5% off" ,"Delivery in 3-4 days", R.drawable.realmex3))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending)



        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Special Offers")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val product: RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Trending)
            adapter = productAdapter{

                var i: Intent = Intent(this@Trending,Discription::class.java).apply {
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
