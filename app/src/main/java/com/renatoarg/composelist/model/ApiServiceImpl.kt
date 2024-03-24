package com.renatoarg.composelist.model

import com.renatoarg.composelist._common.di.ApiModule.Util.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val httpClient: HttpClient) : ApiService {
    override fun getCountries(status: Boolean): Flow<ApiResult<List<CountryItem>>> = flow{
        emit(ApiResult.Loading())
        try {
            val result: List<CountryItem> = httpClient.get(BASE_URL + "independent?status=true").body()
            emit(ApiResult.Success(result.sortedBy { it.name.official }))
        }catch (e:Exception){
            e.printStackTrace()
            emit(ApiResult.Error(e.message ?: "Something went wrong"))
        }
    }
}