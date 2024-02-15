package com.chscorp.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chscorp.aluvery.ui.components.CardProductItem
import com.chscorp.aluvery.ui.components.PartnersSection
import com.chscorp.aluvery.ui.components.ProductsSection
import com.chscorp.aluvery.ui.components.SearchTextField
import com.chscorp.aluvery.model.Product
import com.chscorp.aluvery.sampleData.sampleProducts
import com.chscorp.aluvery.sampleData.sampleSections
import com.chscorp.aluvery.sampleData.sampleShopSections
import com.chscorp.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }
        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
        val searchedProducts = remember(text) {
            sampleProducts.filter { product ->
                product.name.contains(text, ignoreCase = true) ||
                        product.description?.contains(text, ignoreCase = true) ?: false
            }
        }
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {

                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }

                for (shopSections in sampleShopSections){
                    val title = shopSections.key
                    val shop = shopSections.value
                    item {
                        PartnersSection(title = title, shop = shop)
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections, searchText = "a")
        }
    }
}