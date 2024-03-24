package com.renatoarg.composelist.viewmodel


import com.renatoarg.data.country.client.CountryItem

data class PersonUiState(
    val countries: List<CountryItem> = emptyList(),
    val isLoading: Boolean = false
)