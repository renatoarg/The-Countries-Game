package com.renatoarg.data.country.api

import com.renatoarg.data.country.client.CountryItem
import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun getCountries(status:Boolean=true): Flow<ApiResult<List<CountryItem>>>
}