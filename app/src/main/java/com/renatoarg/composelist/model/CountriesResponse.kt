package com.renatoarg.composelist.model

import kotlinx.serialization.Serializable

@Serializable
class CountriesResponse(
    val data: List<String> = emptyList()
)