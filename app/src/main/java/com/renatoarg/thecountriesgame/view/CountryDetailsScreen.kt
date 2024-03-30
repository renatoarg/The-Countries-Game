package com.renatoarg.thecountriesgame.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.renatoarg.domain.viewmodel.CountriesViewModel
import com.renatoarg.thecontriesgame.R
import com.renatoarg.thecountriesgame._common.ShowLoadingCircle

@Composable
fun CountryDetails(
    viewModel: CountriesViewModel,
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    val countriesUiState by viewModel.countries.collectAsState()

    Box(
        modifier = modifier
            .background(Color.Black.copy(.1f))
    ) {
        if (countriesUiState.isLoading) {
            ShowLoadingCircle(true)
        }
        if (countriesUiState.countries.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.empty_list))
            }
        }
        if (countriesUiState.countries.isNotEmpty()) {
            LazyColumn(
                modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
            ) {
                items(countriesUiState.countries) { country ->
                    CountryListItem(
                        country = country,
                        modifier = modifier,
                        onClick = onClick
                    )
                }
            }
        }
        if (countriesUiState.error != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = countriesUiState.error.orEmpty())
            }
        }

    }
}