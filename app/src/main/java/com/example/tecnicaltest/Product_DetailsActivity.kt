package com.example.tecnicaltest

import android.app.Activity
import android.os.Bundle
import com.example.tecnicaltest.databinding.ProductDetailsViewBinding

class Product_DetailsActivity(
    var productId:Int,
    var productTitle:String,
    var productPrice:Int,
    var productImg: String
): Activity() {
  lateinit var productDetailsactivity:Product_DetailsActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ProductDetailsViewBinding = ProductDetailsViewBinding.inflate(layoutInflater)
       productDetailsactivity=intent.getSerializableExtra("productData") as Product_DetailsActivity
    }
}