package com.example.i_restaurant.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i_restaurant.databinding.ProductItemBinding
import com.example.i_restaurant.model.Product

class ProductAdapter(private val context: Context, private val productList: MutableList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}