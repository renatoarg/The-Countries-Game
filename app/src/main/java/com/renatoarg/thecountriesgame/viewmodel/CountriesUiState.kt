package com.renatoarg.thecountriesgame.viewmodel


import com.renatoarg.data.country.client.CountryItem

data class CountriesUiState(
    val countries: List<CountryItem> = emptyList(),
    val isLoading: Boolean = false
)