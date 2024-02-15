package com.chscorp.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chscorp.aluvery.model.Product
import com.chscorp.aluvery.sampleData.sampleProducts
import com.chscorp.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Section(
        title = {
            Text(
                text = title,
                Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            )
        },
        content = {
            LazyRow(
                Modifier
                    .padding(
                        top = 8.dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),// espaçamento entre os elementos da lista
                contentPadding = PaddingValues(horizontal = 16.dp) //espaçmamento inicio e fim da lista
            )
            {
                items(products) { product -> // faz um looping por todos os items da lista products
                    ProductItem(product = product)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }

}