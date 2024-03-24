package com.renatoarg.data.country.api


import com.renatoarg.data.country.client.CountryItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val httpClient: HttpClient) : ApiService {
    override fun getCountries(status: Boolean): Flow<ApiResult<List<CountryItem>>> = flow{

        // emit result loading
        emit(ApiResult.Loading())

        try {

            // fetch countries list
            val countriesList: List<CountryItem> = httpClient.get("independent"){
                parameter("status", true)
            }.body()

            // emit result success
            emit(ApiResult.Success(countriesList.sortedBy { it.name.official }))

        } catch (e:Exception){

            // print console error
            e.printStackTrace()

            // emit result error
            emit(ApiResult.Error(e.message ?: "Something went wrong"))

        }
    }
}