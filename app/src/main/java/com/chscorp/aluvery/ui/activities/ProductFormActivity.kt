package com.chscorp.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.chscorp.aluvery.dao.ProductDao
import com.chscorp.aluvery.ui.screens.ProductFormScreenStateful
import com.chscorp.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {
    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreenStateful ( onSaveClick = { product ->
                        dao.save(product)
                        finish()
                    })
                }
            }
        }
    }
}

