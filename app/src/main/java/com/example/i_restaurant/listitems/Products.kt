package com.example.i_restaurant.listitems

import com.example.i_restaurant.R
import com.example.i_restaurant.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Chesse Pizza",
                price = "10.20"
            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                name = "Mixed Pizza",
                price = "10.20"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Classic Pizza",
                price = "10.20"
            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                name = "Salmon Pizza",
                price = "10.20"
            )
        )
        _productList.value = productList
        return productListFlow
     }
}