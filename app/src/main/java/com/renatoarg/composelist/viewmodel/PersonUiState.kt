package com.renatoarg.composelist.viewmodel

import com.renatoarg.composelist.model.Person

data class PersonUiState(
    val persons: List<Person> = emptyList(),
    val isLoading: Boolean = false
)