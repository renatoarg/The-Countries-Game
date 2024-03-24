package com.renatoarg.composelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renatoarg.data.country.api.ApiResult
import com.renatoarg.data.country.api.ApiService
import com.renatoarg.data.country.client.CountryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val apiService: ApiService,
    private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _countries= MutableStateFlow<ApiResult<List<CountryItem>>>(ApiResult.Loading())
    val countries= _countries.asStateFlow()

    init {
        fetchCountries()
    }

    private fun fetchCountries(){
        viewModelScope.launch {
            apiService.getCountries()
                .flowOn(defaultDispatcher)
                .catch {
                    _countries.value= ApiResult.Error(it.message ?: "Something went wrong")
                }
                .collect{
                    _countries.value=it
                }
        }
    }
}