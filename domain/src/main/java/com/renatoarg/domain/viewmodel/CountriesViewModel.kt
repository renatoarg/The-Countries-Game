package com.renatoarg.domain.viewmodel

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

    private val _countries = MutableStateFlow(CountriesUiState(countries = emptyList(), isLoading = true))
    val countries = _countries.asStateFlow()

    init {
        fetchCountries()
    }

    private fun fetchCountries(){
        viewModelScope.launch {
            apiService.getCountries()
                .flowOn(defaultDispatcher)
                .catch {
                    _countries.value = _countries.value.copy(countries = emptyList(), isLoading = false, error = it.message ?: "Something went wrong")
                }
                .collect{ apiResult ->
                    _countries.value = when (apiResult) {
                        is ApiResult.Loading -> {
                            _countries.value.copy(isLoading = true, error = null)
                        }
                        is ApiResult.Success -> {
                            val countries = (apiResult.data as List<CountryItem>).map {
                                CountryUi(
                                    name = it.name.official,
                                    imageUrl = it.flags.png
                                )
                            }
                            _countries.value.copy(countries = countries.sortedBy { country -> country.name }, isLoading = false, error = null)
                        }
                        is ApiResult.Error -> {
                            val error = apiResult.error as String
                            _countries.value.copy(countries = emptyList(), isLoading = false, error = error)
                        }
                    }
                }
        }
    }
}