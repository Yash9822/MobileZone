package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Oneplus : AppCompatActivity() {

    val productview = arrayOf(products("OnePlus 7T Pro, 256  GB","Haze Blue","₹48,595","₹53,288",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 2-3 days", R.drawable.seventpro),
            products("OnePlus 7T Pro, 256  GB","Haze Blue","₹48,595","₹53,288",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 2-3 days", R.drawable.seventpro),
            products("OnePlus 7T Pro, 256  GB","Haze Blue","₹48,595","₹53,288",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 2-3 days", R.drawable.seventpro),
            products("OnePlus 7T Pro, 256  GB","Haze Blue","₹48,595","₹53,288",R.drawable.ic_line_thick,"8% Off" ,"Delivery in 2-3 days", R.drawable.seventpro))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oneplus)


        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Oneplus")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Oneplus)
            adapter = productAdapter{

                var i:Intent = Intent(this@Oneplus,Discription::class.java).apply {
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
