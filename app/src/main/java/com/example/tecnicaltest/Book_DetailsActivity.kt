package com.example.tecnicaltest

import android.app.Activity
import android.os.Bundle
import com.example.tecnicaltest.databinding.BookDetailsViewBinding

class Book_DetailsActivity(
    var bookId:Int,
    var bookTitle:String,
    var bookPrice:Int,
    var bookDescription:String
): Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:BookDetailsViewBinding= BookDetailsViewBinding.inflate(layoutInflater)

    }
}