package com.renatoarg.thecountriesgame.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.renatoarg.domain.viewmodel.CountriesUiState
import com.renatoarg.domain.viewmodel.CountryUi
import com.renatoarg.thecountriesgame._common.ShowLoadingCircle
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun CountriesMainScreen(
    state: MutableStateFlow<CountriesUiState>,
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    val countriesUiState by state.collectAsState()

    Box(
        modifier = modifier
            .background(Color.Black.copy(.1f))
    ) {
        if (countriesUiState.isLoading) {
            ShowLoadingCircle(true)
            return
        }
        if (countriesUiState.countries.isEmpty()) {
            CountriesEmptyScreen()
            return
        }
        if (countriesUiState.countries.isNotEmpty()) {
            CountriesListScreen(
                countries = countriesUiState.countries.toMutableList(),
                modifier = Modifier,
                onClick = onClick
            )
            return
        }
        if (countriesUiState.error != null) {
            CountriesErrorScreen()
            return
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showEmptyCountriesList() {
    CountriesMainScreen(
        state = MutableStateFlow(
            CountriesUiState(
                countries = emptyList(),
                isLoading = false,
                error = null)
        ),
        modifier = Modifier,
        onClick = {

        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showIsLoadingCountriesList() {
    CountriesMainScreen(
        state = MutableStateFlow(
            CountriesUiState(
                countries = emptyList(),
                isLoading = true,
                error = null)
        ),
        modifier = Modifier,
        onClick = {

        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showCountriesList() {
    CountriesMainScreen(
        state = MutableStateFlow(
            CountriesUiState(
                countries = listOf(
                    CountryUi(
                        name = "Brazil",
                        imageUrl = "http://image.jpeg"
                    ),
                    CountryUi(
                        name = "Outro",
                        imageUrl = "http://image.jpeg"
                    ),
                    CountryUi(
                        name = "Another",
                        imageUrl = "http://image.jpeg"
                    ),
                ),
                isLoading = false,
                error = null)
        ),
        modifier = Modifier,
        onClick = {

        }
    )
}