package com.alpamedev.mdcjc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alpamedev.mdcjc.ui.theme.MDCJCTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    MDCJCTheme {
        Content()
    }
}


@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())  //Estados de la barra de desplazamiento
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {

            }
        }
    }
}