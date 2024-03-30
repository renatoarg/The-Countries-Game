package com.renatoarg.thecountriesgame.view

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatoarg.domain.viewmodel.CountryUi

@Composable
fun CountriesListScreen(
    countries: MutableList<CountryUi>,
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
    ) {
        items(countries) { country ->
            CountryListItem(
                country = country,
                modifier = modifier,
                onClick = onClick
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCountriesListScreen() {
    CountriesListScreen(
        countries = mutableListOf(
            CountryUi(
                name = "Name 1",
                imageUrl = ""
            ),
            CountryUi(
                name = "Name 2",
                imageUrl = ""
            ),
            CountryUi(
                name = "Name 3",
                imageUrl = ""
            ),
        ),
        modifier = Modifier,
        onClick = {
            Log.d("PreviewCountriesListScreen", "PreviewCountriesListScreen: onClick")
        }
    )
}