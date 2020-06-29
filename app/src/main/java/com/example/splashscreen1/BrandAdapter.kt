package com.example.splashscreen1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class BrandAdapter(val brandData:Array<Brands>): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        val brandview: View
        val viewHolder: ViewHolder

        if(convertView == null){
            brandview = LayoutInflater.from(container.context).inflate(R.layout.brandlist,
                container, false)

            viewHolder = ViewHolder()
            with(viewHolder){
                brandName = brandview.findViewById(R.id.brand_name)
                Logo = brandview.findViewById(R.id.logo_)
                brandview.tag = this
            }
        } else{
            brandview = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        with(viewHolder){
            brandName.text = brandData[position].brandName
            Logo.setImageResource(brandData[position].Logo)

        }

        return brandview
    }

    private class ViewHolder{
        lateinit var brandName: TextView
        lateinit var Logo: ImageView
    }

    override fun getItem(position: Int): Brands {
        return brandData[position]
    }

    override fun getItemId(position: Int): Long {
        return brandData[position].brandName.hashCode().toLong()
    }

    override fun getCount(): Int {
        return brandData.size
    }


}