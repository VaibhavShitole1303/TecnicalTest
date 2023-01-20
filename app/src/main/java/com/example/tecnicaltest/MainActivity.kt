package com.example.tecnicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnicaltest.databinding.ActivityMainBinding

class MainActivity(

) : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var products:ArrayList<Product>
    private lateinit var books:ArrayList<Book>
    private lateinit var commonAdapter: CommonAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)

        initView()
        initData()
    }

    private fun initData() {
        products=ArrayList()
        for (i in 0..20){
            products.add(
                Product(
                    i,
                    "Product No $i",
                    200+i,
                    "${R.drawable.ic_launcher_foreground}"
                )
            )
        }
        books=ArrayList()
        for(i in 0..5){
            books.add(
                Book(
                    i,
                    "Book no $i",
                    100+i,
                    "this book is about $i"
                )
            )
        }
    }

    private fun initView() {
        recyclerview=findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerview.adapter=CommonAdapter(products,books)
        // commonAdapter= CommonAdapter(products, books )
        // recyclerview.adapter=commonAdapter

    }
    }
