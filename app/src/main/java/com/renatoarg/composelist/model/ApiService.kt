package com.renatoarg.composelist.model

import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun getCountries(status:Boolean=true): Flow<ApiResult<List<CountryItem>>>
}