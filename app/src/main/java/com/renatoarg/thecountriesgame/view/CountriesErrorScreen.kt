package com.renatoarg.thecountriesgame.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatoarg.thecontriesgame.R
import com.renatoarg.thecountriesgame._common.LoadImageFromResource

@Composable
fun CountriesErrorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocalContext.current.getDrawable(R.drawable.baseline_error_24)?.let {
            LoadImageFromResource(imageUrl = it, contentDescription = "Image")
        }
        Text(text = stringResource(id = R.string.empty_list))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCountriesErrorScreen() {
    CountriesErrorScreen()
}