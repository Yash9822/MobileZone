package com.example.splashscreen1

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class productAdapter(private val listener :(products)-> Unit): RecyclerView.Adapter<productAdapter.ProductViewHolder>() {


    var productData= arrayOf<products>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    inner class ProductViewHolder (view: View): RecyclerView.ViewHolder(view){

        val productImage: ImageView = view.findViewById(R.id.imageView)
        val productTitle: TextView = view.findViewById(R.id.textViewTitle)
        val productColor: TextView = view.findViewById(R.id.textColorType)
        val productNewPrice: TextView = view.findViewById(R.id.textViewNewprice)
        val productPrice: TextView = view.findViewById(R.id.textViewprice)
        val productLine: ImageView = view.findViewById(R.id.imageViewLine)
        val productDiscount: TextView = view.findViewById(R.id.discount)
        val productDelivery: TextView = view.findViewById(R.id.textViewDelivery)

        init {
            itemView.setOnClickListener {

                listener.invoke(productData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productLayout=LayoutInflater.from(parent.context)
                .inflate(R.layout.product_lists,parent,false)
        return ProductViewHolder(productLayout)
    }

    override fun getItemId(position: Int): Long {
        return productData[position].hashCode().toLong()
    }

    override fun getItemCount() = productData.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        with(holder){
            productImage.setImageResource(productData[position].productId)
            productTitle.text=productData[position].title
            productColor.text=productData[position].color
            productNewPrice.text=productData[position].newPrice
            productPrice.text=productData[position].price
            productLine.setImageResource(productData[position].Line)
            productDiscount.text=productData[position].Discount
            productDelivery.text=productData[position].Delivery
        }
    }
}