package com.example.tecnicaltest

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnicaltest.databinding.BookViewBinding
import com.example.tecnicaltest.databinding.ProductViewBinding

class CommonAdapter(
    private var products: ArrayList<Product>,
    private var books: ArrayList<Book>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val VIEW_TYPE_PRODUCT=1
    val VIEW_TYPE_BOOK=2
    lateinit var bindingProduct: ProductViewBinding
    lateinit var bindingBook: BookViewBinding
    lateinit var product:Product
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var bindingProduct: ProductViewBinding


    }
    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var bindingBook: BookViewBinding
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        if (viewType==VIEW_TYPE_PRODUCT){
            var productView:View=layoutInflater.inflate(R.layout.product_view,null)
            productView.setOnClickListener{
                var  intent:Intent=Intent(parent.context,Product_DetailsActivity::class.java)
                intent.putExtra("productData",product)

            }
            return ProductViewHolder(productView)

        }
        var advertisementView=layoutInflater.inflate(R.layout.book_view,null)
        return BookViewHolder(advertisementView)
    }
    override fun getItemViewType(position: Int): Int {
        if ((position+1)%3==0){
            return VIEW_TYPE_BOOK
        }
        return VIEW_TYPE_PRODUCT
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ProductViewHolder){
            var product=products[position-position/3]
            holder.bindingProduct.ProductTitle.text=product.productTitle
            holder.bindingProduct.ProductId.text= product.productId.toString()

            holder.bindingProduct.ProductPrice.text=(product.productPrice.toString())
        }
        if (holder is BookViewHolder){
            var BookPosition=(position+1)/3-1
            if (BookPosition>=books.size){
                BookPosition=BookPosition%5
            }
            var book=books[BookPosition]
            holder.bindingBook.BookId.text= book.bookId.toString()
            holder.bindingBook.BookPrice.text=book.bookPrice.toString()
            holder.bindingBook.BookTitle.text=book.bookTitle
            holder.bindingBook.BookId.text=book.bookDescription

        }
    }

    override fun getItemCount(): Int {
       return products.size + books.size
    }
}