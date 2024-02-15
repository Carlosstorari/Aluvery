package com.chscorp.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chscorp.aluvery.ui.theme.AluveryTheme

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "Texto1")
        Text(text = "Texto2")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        Text(text = "Texto1")
        Text(text = "Texto2")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "Texto1")
        Text(text = "Texto2")
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "Meu primeiro texto")
    Text(text = "Meu segundo texto ainda maior")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
            .background(color = Color.Blue)
            .padding(all = 8.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = "Texto1")
        Text(text = "Texto2")
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .background(Color.Green)
                .fillMaxWidth(0.5f)
        ) {
            Text(text = "Texto3")
            Text(text = "Texto4")
        }
        Box(
            Modifier
                .background(color = Color.Red)
                .padding(all = 8.dp)
                .width(100.dp)
        ) {
            Row(
                Modifier
                    .background(color = Color.Cyan)
                    .padding(all = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Texto5")
                Text(text = "Texto6")
            }
            Column(
                Modifier
                    .background(color = Color.Yellow)
                    .padding(all = 8.dp)) {
                Text(text = "Texto7")
                Text(text = "Texto8")
            }
        }
    }
}

@Preview
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}