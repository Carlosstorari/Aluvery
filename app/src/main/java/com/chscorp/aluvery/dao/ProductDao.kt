package com.chscorp.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.chscorp.aluvery.model.Product
import com.chscorp.aluvery.sampleData.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}