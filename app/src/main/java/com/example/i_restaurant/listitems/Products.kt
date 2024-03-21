package com.example.i_restaurant.listitems

import com.example.i_restaurant.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>> {
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = 
            )
        )
    }
}