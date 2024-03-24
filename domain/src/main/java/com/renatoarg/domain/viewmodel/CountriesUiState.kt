package com.renatoarg.domain.viewmodel


import com.renatoarg.data.country.client.CountryItem

data class CountriesUiState(
    val countries: List<CountryUi> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class CountryUi(
    val name: String,
    val imageUrl: String
)