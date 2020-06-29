package com.example.splashscreen1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Realme : AppCompatActivity() {

    val productview = arrayOf(products("Realme X, 128 GB", "Space Blue", "₹18,999", "₹20,999", R.drawable.ic_line_thick, "9% Off", "Delivery in 2-3 days", R.drawable.realmex),
            products("Realme X3 SuperZoom, 256 GB","Glacier Blue","₹32,999","₹34,999",R.drawable.ic_line_thick,"5% off" ,"Delivery in 3-4 days", R.drawable.realmex3),
            products("Realme Narzo 10A, 32GB","So Blue","₹34,999","₹37,900",R.drawable.ic_line_thick,"7% off" ,"Delivery in 3-4 days", R.drawable.realmenarzo))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realme)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Realme")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Realme)
            adapter = productAdapter{

                var i: Intent = Intent(this@Realme,Discription::class.java).apply {
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
