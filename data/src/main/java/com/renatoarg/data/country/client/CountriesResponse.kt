package com.renatoarg.data.country.client

import kotlinx.serialization.Serializable

@Serializable
class CountriesResponse(
    val data: List<String> = emptyList()
)