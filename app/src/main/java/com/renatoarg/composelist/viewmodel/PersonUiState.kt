package com.renatoarg.composelist.viewmodel


import com.renatoarg.composelist.model.CountryItem

data class PersonUiState(
    val countries: List<CountryItem> = emptyList(),
    val isLoading: Boolean = false
)