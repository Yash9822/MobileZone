package com.example.splashscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_apple.*

class Vivo : AppCompatActivity() {

    val productview = arrayOf(products("Vivo NEX, 128 GB","Black","₹23,990","₹39,990",R.drawable.ic_line_thick,"40% Off" ,"Delivery in 2-3 days", R.drawable.nex),
            products("Vivo Z1x, 128GB","Fusion Blue","₹17,990","₹24,990",R.drawable.ic_line_thick,"28% Off" ,"Delivery in 3-4 days", R.drawable.vivoz1x))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vivo)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Vivo")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val product:RecyclerView = findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager = LinearLayoutManager(this@Vivo)
            adapter = productAdapter{

                var i:Intent = Intent(this@Vivo,Discription::class.java).apply {
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
